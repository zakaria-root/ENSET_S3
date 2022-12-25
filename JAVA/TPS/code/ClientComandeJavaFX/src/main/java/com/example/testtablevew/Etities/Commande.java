package com.example.testtablevew.Etities;

public class Commande {
    private int id;
    private String reference;
    private String dateCreation;
    private double prix;

    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Commande() {
    }

    public Commande(int id, String reference, String dateCreation, double prix, Client client) {
        this.id = id;
        this.reference = reference;
        this.dateCreation = dateCreation;
        this.prix = prix;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", dateCreation='" + dateCreation + '\'' +
                ", prix=" + prix +
                ", client=" + client +
                '}';
    }
}

