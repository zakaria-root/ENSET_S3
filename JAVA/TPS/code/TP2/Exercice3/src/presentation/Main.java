package presentation;

import metier.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //initilise la class categorie

//        déclarez et intentiez une liste de trois ordinateurs ;
        List<Ordinateur> ordinateurs = new ArrayList<>(3);
        ordinateurs.add(new Ordinateur("nom1", "marque1", 100.0, "description1", new ArrayList<>(), null));
        ordinateurs.add(new Ordinateur("nom2", "marque2", 200.0, "description2", new ArrayList<>(), null));
        ordinateurs.add(new Ordinateur("nom3", "marque3", 300.0, "description3", new ArrayList<>(), null));

//— déclarez et intentiez une catégorie ;
        Categorie categorie = new Categorie("nom", "description", ordinateurs);
        for (Ordinateur o : ordinateurs) {
            o.setCategorie(categorie);
        }
//— déclarez et intentiez un client ;
        Client client = new Client("nom", "prenom", "adresse", "ville", "telephone", "email", new ArrayList<Commande>());
//— déclarez et instanciez une commande du client ;
        Commande commande = commande = new Commande(1, client, new Date(), "etatDeCommande", new ArrayList<>());
        client.ajouterCommande(commande);

//— déclarez et instanciez une liste de trois lignes de commandes pour la commande et les ordinateurs créés ;
        List<LigneCommande> ligneDeCommandes = new ArrayList<>(3);


        LigneCommande ligneDeCommande = new LigneCommande(1, ordinateurs.get(0), commande);
        LigneCommande ligneDeCommande1 = new LigneCommande(2, ordinateurs.get(1), commande);
        LigneCommande ligneDeCommande2 = new LigneCommande(3, ordinateurs.get(2), commande);
        ligneDeCommandes.add(ligneDeCommande);
        ligneDeCommandes.add(ligneDeCommande1);
        ligneDeCommandes.add(ligneDeCommande2);
        commande.getLigneCommandes().addAll(ligneDeCommandes);

        ordinateurs.get(0).getLigneCommandes().add(ligneDeCommande);
        ordinateurs.get(1).getLigneCommandes().add(ligneDeCommande1);
        ordinateurs.get(2).getLigneCommandes().add(ligneDeCommande2);
//— affichez toutes les informations de la commande.

        System.out.println(commande);
    }



}