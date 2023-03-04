package com.robertndlala.submission.service;


import java.util.List;
import java.util.Optional;

import com.robertndlala.submission.entity.ClientModel;
import com.robertndlala.submission.exception.ItemExistsException;
import com.robertndlala.submission.exception.ResourceNotFoundException;
import com.robertndlala.submission.repository.ClientRepository;
import org.springframework.stereotype.Service;

import com.robertndlala.submission.entity.ClientInfo;
import com.robertndlala.submission.exception.ClientNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {


    ClientRepository clientRepository;

    @Override
    public ClientInfo getClient(Long id) {
        Optional<ClientInfo> clientInfo = clientRepository.findById(id);
        return unwrapClient(clientInfo, id);
    }

    @Override

    public ClientInfo saveClient(ClientInfo clientInfo) {

        if (clientRepository.existsByIdnumber(clientInfo.getIdnumber())) {
            throw new ItemExistsException("Id Number is already register with :" + clientInfo.getIdnumber());
        }

        if (clientRepository.existsByIdnumber(clientInfo.getMobile())) {
            throw new ItemExistsException("Phone Number is already register with :"+clientInfo.getMobile());
        }

        return clientRepository.save(clientInfo);

    }


    @Override
    public List<ClientInfo> getClient() {
        return (List<ClientInfo>)clientRepository.findAll();
    }

    @Override
    public ClientInfo readClient() {
        Long clientId = readClient().getCount();
        return clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("User not found for the id:"+clientId));
    }

    @Override
    public ClientInfo updateClient(ClientInfo clientInfo) {

        ClientInfo existingClient = readClient();

        existingClient.setFirst_name(clientInfo.getFirst_name() != null ? clientInfo.getFirst_name() : existingClient.getFirst_name());
        existingClient.setLast_name(clientInfo.getLast_name() != null ? clientInfo.getLast_name() : existingClient.getLast_name());
        existingClient.setMobile(clientInfo.getMobile() != null ? clientInfo.getMobile() : existingClient.getMobile());
        existingClient.setIdnumber(clientInfo.getIdnumber() != null ? clientInfo.getIdnumber() : existingClient.getIdnumber());
        existingClient.setPhysical_address(clientInfo.getPhysical_address() != null ? clientInfo.getPhysical_address() : existingClient.getPhysical_address());
        return clientRepository.save(existingClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }



    static ClientInfo unwrapClient(Optional<ClientInfo> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new ClientNotFoundException(id);
    }


}
