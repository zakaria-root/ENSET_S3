package ma.application.main;

import ma.application.businessmodel.Client;
import ma.application.businessmodel.Facture;
import ma.application.businessmodel.LigneDeCommande;
import ma.application.businessmodel.Produit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("entrer le nombre des clients ");
        int nbClient = sc.nextInt();
        List<Client> clients = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < nbClient; i++) {
            System.out.println("entrer le nom de client n" + (i + 1));
            clients.add(getClient(Long.valueOf(1), sc.nextLine()));
        }


        List<Facture> facturesClient = new ArrayList<>();
        for (Client client : clients) {
            facturesClient.addAll(getFactures(client));
        }


        List<LigneDeCommande> ligneDeCommandes = new ArrayList<>();
        for (Facture facture : facturesClient) {
            ligneDeCommandes.addAll(facture.getLignesDeCommande());
        }

        List<Produit> produits = new ArrayList<>();
        boolean exist;
        int index;
        AtomicBoolean existfacture = new AtomicBoolean(false);
        AtomicBoolean existClient = new AtomicBoolean(false);
        for (LigneDeCommande lignesDeCommande : ligneDeCommandes) {
            exist = false;
            index = 0;
            while (index < produits.size() && exist != true) {
                if (produits.get(index).getDesignation().equals(lignesDeCommande.getProduit().getDesignation())) {
                    exist = true;
                } else {
                    index++;
                }
            }

            if (exist == true) {
                existfacture.set(false);
                produits.get(index).getLigneDeCommande().getFacture().forEach(facture -> {
                    if (facture.getNumero().equals(lignesDeCommande.getFacture().get(0).getNumero())) {
                        existfacture.set(true);
                    }
                });

                if (!existfacture.get()) {
                    produits.get(index).getLigneDeCommande().getFacture().addAll(lignesDeCommande.getFacture());
                }

                produits.get(index).getLigneDeCommande().getFacture().forEach(facture -> {
                    existClient.set(false);
                    facture.getClient().forEach(client -> {
                        if (client.getNom().equals(lignesDeCommande.getFacture().get(0).getClient().get(0).getNom())) {
                            existClient.set(true);
                        }
                    });
                    if (!existClient.get()) {
                        facture.getClient().add(lignesDeCommande.getFacture().get(0).getClient().get(0));
                    }
                });

                produits.get(index).getLigneDeCommande().setQte(produits.get(index).getLigneDeCommande().getQte() + lignesDeCommande.getQte());
                produits.get(index).getLigneDeCommande().setSouTotal(produits.get(index).getLigneDeCommande().getSouTotal() + lignesDeCommande.getSouTotal());
            } else {

                produits.add(lignesDeCommande.getProduit());
                produits.get(produits.size() - 1).setLigneDeCommande(lignesDeCommande);

            }

        }
        System.out.println("Dashboard des produits...");

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("    produit     |   fois   |      totale      |    factures    |   Clients");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Produit produit : produits) {
            System.out.print("    " + produit.getDesignation() + "    |    " + produit.getLigneDeCommande().getQte() + "      |     " + produit.getLigneDeCommande().getSouTotal() + "     |    ");
            for (Facture facture : produit.getLigneDeCommande().getFacture()) {
                System.out.print(facture.getNumero() + " ");
            }
            System.out.print("    |    ");
            for (Client client : produit.getLigneDeCommande().getFacture().get(0).getClient())
                System.out.print(client.getNom() + ", ");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------");

        }
    }

    public static Client getClient(Long idClient, String nom) {
        return new Client(Long.valueOf(1), nom);
    }

    public static List<Facture> getFactures(Client client) {

        System.out.println("le nombre des factures");
        int nbFacture = sc.nextInt();
        int nbProduit;
        String nomProduit;
        double prixroduit;
        int qtProduit;
        Produit produit;
        List<LigneDeCommande> lignesDeCommande = new ArrayList<>();
        List<Facture> facturesClient = new ArrayList<>();
        Facture facture;
        for (int i = 0; i < nbFacture; i++) {
            System.out.println("le nombre des produit de la facture n" + (i + 1));
            facture = new Facture((i + 1) + "/A", new Date(2020, 1, 1), client);
            nbProduit = sc.nextInt();
            sc.nextLine();
            lignesDeCommande.clear();
            for (int j = 0; j < nbProduit; j++) {
                sc.nextLine();
                System.out.println("entrez le nom de la produit n:" + (j + 1));
                nomProduit = sc.nextLine();
                System.out.println("entrez le prix de la produit n:" + (j + 1));
                prixroduit = sc.nextDouble();
                produit = new Produit(Long.valueOf(1), nomProduit, prixroduit);
                System.out.println("entrez la quatite de la produit n:" + (j + 1));
                qtProduit = sc.nextInt();
                LigneDeCommande ligne = new LigneDeCommande(Long.valueOf(1), qtProduit, qtProduit * prixroduit, facture, produit);
                produit.setLigneDeCommande(ligne);
                lignesDeCommande.add(ligne);
            }
            facture.setLignesDeCommande(lignesDeCommande);
            facturesClient.add(facture);
        }


        return facturesClient;
    }
}
