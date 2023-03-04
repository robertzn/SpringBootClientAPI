package com.robertndlala.submission.web;

import java.util.List;

import com.robertndlala.submission.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.robertndlala.submission.entity.ClientInfo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ClientInfo> getClient(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ClientInfo> saveClient(@RequestBody ClientInfo clientInfo) {
        return new ResponseEntity<>(clientService.saveClient(clientInfo), HttpStatus.CREATED);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/profile")
    public ResponseEntity<ClientInfo> updateClient(@RequestBody ClientInfo clientInfo) {
        return new ResponseEntity<ClientInfo>(clientService.updateClient(clientInfo), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientInfo>> getClient() {
        return new ResponseEntity<>(clientService.getClient(), HttpStatus.OK);
    }


}
