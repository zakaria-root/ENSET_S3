package com.example.testtablevew.Services;

import com.example.testtablevew.Etities.Client;

import java.util.List;

public interface ClientService {
    public void add(Client client);
    public void update(Client client);
    public void delete(Client client);
    public Client findById(int id);
    public void deleteAll();
    public List<Client> findAll();

}
