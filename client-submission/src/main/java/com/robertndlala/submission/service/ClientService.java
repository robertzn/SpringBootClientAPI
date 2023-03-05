package com.robertndlala.submission.service;

import java.util.List;

import com.robertndlala.submission.entity.ClientInfo;
import com.robertndlala.submission.entity.ClientModel;

public interface ClientService {
    ClientInfo getClient(Long id);
    ClientInfo saveClient(ClientInfo clientInfo);
    ClientInfo updateClient(ClientInfo clientInfo);

    Object checkIfStudentIsNull(int i);

    ClientInfo readClient();
    void deleteClient(Long id);

    List<ClientInfo> getClient();

    //boolean checkIfClientIsNull(int i);
}