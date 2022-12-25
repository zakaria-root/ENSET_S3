package com.example.testtablevew.Services;

import com.example.testtablevew.Dao.CommandeDao;
import com.example.testtablevew.Etities.Commande;

import java.util.List;

public class CommandeServiceImp implements CommadeService {
    private CommandeDao commandeDao;

    public CommandeServiceImp(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }


    @Override
    public void add(Commande commande) {
        commandeDao.add(commande);

    }

    @Override
    public void update(Commande commande) {
        // TODO Auto-generated method stub
        commandeDao.update(commande);
    }

    @Override
    public void delete(Commande commande) {
        // TODO Auto-generated method stub
        commandeDao.delete(commande);
    }

    @Override
    public Commande findById(int id) {
        // TODO Auto-generated method stub
       return  commandeDao.findById(id);
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        commandeDao.deleteAll();
    }

    @Override
    public List<Commande> findAll() {
        // TODO Auto-generated method stub
        return commandeDao.findAll();
    }


}
