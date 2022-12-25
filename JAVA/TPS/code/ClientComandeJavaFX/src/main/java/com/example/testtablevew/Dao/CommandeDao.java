package com.example.testtablevew.Dao;

import com.example.testtablevew.Etities.Commande;
import com.example.testtablevew.Etities.Commande;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommandeDao implements Dao<Commande> {


    @Override
    public void add(Commande c) {
        com.example.dbconnection.DBI.DBInteraction.connect();
        String req = "insert into commandes (reference, dateCreation, prix, idClient ) values ('" + c.getReference() + "','" + c.getDateCreation() + "'," + c.getPrix() + ", " + c.getClient().getId() + ")";
        Boolean result  = com.example.dbconnection.DBI.DBInteraction.update(req);
        if (result) {
            System.out.println("Commandes added");
        } else {
            System.out.println("Commandes not added");
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
    }

    @Override
    public void update(Commande c) {
        com.example.dbconnection.DBI.DBInteraction.connect();
        String sql = "UPDATE `commandes` SET `reference` = '"+c.getReference()+"', `dateCreation` = '"+c.getDateCreation()+"', `prix` = "+c.getPrix()+", `idClient` = "+ c.getClient().getId()+" WHERE `commandes`.`id` = "+c.getId();
        Boolean result  = com.example.dbconnection.DBI.DBInteraction.update(sql);
        if (result){
            System.out.println("update success");
        }else {
            System.out.println("update failed");
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
    }

    @Override
    public void delete(Commande t) {
        com.example.dbconnection.DBI.DBInteraction.connect();
        Boolean result  = com.example.dbconnection.DBI.DBInteraction.update("delete from commandes where id = "+t.getId());
        if (result){
            System.out.println("Commande supprimé");
        }else {
            System.out.println("Commande non supprimé");
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
    }

    @Override
    public Commande findById(int id) {
        com.example.dbconnection.DBI.DBInteraction.connect();
        String sql = "select * from commandes where id = " + id;
        ResultSet rs = com.example.dbconnection.DBI.DBInteraction.select(sql);
        Commande c = new Commande();
        try {
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setReference(rs.getString("reference"));
                c.setDateCreation(rs.getString("dateCreation"));
                c.setPrix(rs.getDouble("prix"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
        return c;
    }

    @Override
    public List<Commande> findAll() {
        com.example.dbconnection.DBI.DBInteraction.connect();
        ResultSet rs = com.example.dbconnection.DBI.DBInteraction.select("select * from commandes");
        List<Commande> commandes = new ArrayList<>();
        try {
            while (rs.next()) {
                Commande commande = new Commande();
                commande.setId(rs.getInt("id"));
                commande.setDateCreation(rs.getString("dateCreation"));
                commande.setReference(rs.getString("reference"));
                commande.setPrix(rs.getDouble("prix"));
                commande.setClient(new ClientDao().findById(rs.getInt("idClient")));
                commandes.add(commande);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
        return commandes;
    }

    @Override
    public void deleteAll() {
        com.example.dbconnection.DBI.DBInteraction.connect();
        Boolean result  = com.example.dbconnection.DBI.DBInteraction.update("delete from commandes");
        if (result){
            System.out.println("Commandes supprimés");
        }else {
            System.out.println("Commandes non supprimés");
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
    }

}
