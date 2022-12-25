package com.example.testtablevew.Dao;

import com.example.testtablevew.Etities.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements Dao<Client> {

    @Override
    public void add(Client t) {
        com.example.dbconnection.DBI.DBInteraction.connect();
        String req = "insert into clients (nom, prenom, age, adresse, telephone) values ('" + t.getNom() + "','" + t.getPrenom() + "'," + t.getAge() + ",'" + t.getAdresse() + "','" + t.getTelephone() + "')";
        Boolean result  = com.example.dbconnection.DBI.DBInteraction.update(req);
        if (result) {
            System.out.println("Client added");
        } else {
            System.out.println("Client not added");
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
    }

    @Override
    public void update(Client t) {
        com.example.dbconnection.DBI.DBInteraction.connect();
        String sql = "UPDATE `clients` SET `nom` = '"+t.getNom()+"', `prenom` = '"+t.getPrenom()+"', `age` = "+t.getAge()+", `adresse` = '"+t.getAdresse()+"', `telephone` = '"+t.getTelephone()+"' WHERE `clients`.`id` = "+t.getId();
        Boolean result  = com.example.dbconnection.DBI.DBInteraction.update(sql);
        if (result){
            System.out.println("update success");
        }else {
            System.out.println("update failed");
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
    }

    @Override
    public void delete(Client t) {
        com.example.dbconnection.DBI.DBInteraction.connect();
        Boolean result  = com.example.dbconnection.DBI.DBInteraction.update("delete from clients where id = "+t.getId());
        if (result){
            System.out.println("Client supprimé");
        }else {
            System.out.println("Client non supprimé");
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
    }

    @Override
    public Client findById(int id) {
        com.example.dbconnection.DBI.DBInteraction.connect();
        String sql = "select * from clients where id = " + id;
        ResultSet rs = com.example.dbconnection.DBI.DBInteraction.select(sql);
        Client c = new Client();
        try {
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAge(rs.getInt("age"));
                c.setAdresse(rs.getString("adresse"));
                c.setTelephone(rs.getString("telephone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
        return c;
    }

    @Override
    public List<Client> findAll() {
        com.example.dbconnection.DBI.DBInteraction.connect();
        ResultSet rs = com.example.dbconnection.DBI.DBInteraction.select("select * from clients");
        List<Client> clients = new ArrayList<>();
        try {
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setAdresse(rs.getString("adresse"));
                client.setTelephone(rs.getString("telephone"));
                clients.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
        return clients;
    }

    @Override
    public void deleteAll() {
        com.example.dbconnection.DBI.DBInteraction.connect();
        Boolean result  = com.example.dbconnection.DBI.DBInteraction.update("delete from clients");
        if (result){
            System.out.println("Clients supprimés");
        }else {
            System.out.println("Clients non supprimés");
        }
        com.example.dbconnection.DBI.DBInteraction.disconnect();
    }

}
