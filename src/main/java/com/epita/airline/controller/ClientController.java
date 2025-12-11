package com.epita.airline.controller;

import com.epita.airline.model.Client;
import com.epita.airline.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void createClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @GetMapping
    public List<Client> getClients() {
        return clientService.getAllClients();
    }
}
