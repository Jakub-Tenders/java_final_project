package com.epita.airline.service;

import com.epita.airline.dao.ClientDAO;
import com.epita.airline.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void addClient(Client client) {
        clientDAO.save(client);
    }

    public List<Client> getAllClients() {
        return clientDAO.findAll();
    }
}
