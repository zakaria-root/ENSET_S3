package com.example.testtablevew.Services;

import com.example.testtablevew.Dao.ClientDao;
import com.example.testtablevew.Etities.Client;

import java.util.List;

public class ClientServiceImp implements ClientService {
    private ClientDao clientDao;

    public ClientServiceImp(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    @Override
    public void add(Client client) {
        clientDao.add(client);

    }

    @Override
    public void update(Client client) {
        // TODO Auto-generated method stub
        clientDao.update(client);
    }

    @Override
    public void delete(Client client) {
        // TODO Auto-generated method stub
        clientDao.delete(client);
    }

    @Override
    public Client findById(int id) {
        // TODO Auto-generated method stub
        return clientDao.findById(id);
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        clientDao.deleteAll();
    }

    @Override
    public List<Client> findAll() {
        // TODO Auto-generated method stub
        return clientDao.findAll();
    }


}
