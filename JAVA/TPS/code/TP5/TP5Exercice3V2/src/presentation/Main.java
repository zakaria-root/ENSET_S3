package presentation;

import metier.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME_CLIENT = "clients.dat";
    private static final String FILE_NAME_PRODUIT = "produit.dat";


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        IMetier<Client> ml = new MetierImp<>(new ArrayList<>(), FILE_NAME_CLIENT);
        IMetier<Produit> mp = new MetierImp<>(new ArrayList<>(), FILE_NAME_PRODUIT);

        do {
            menu();
            System.out.println("entre votre choix :");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    gestionClient(ml);
                    break;
                case 2:
                    gestionProduit(mp);
                    break;
                case 3:
                    exit(1);
                    break;
                default:
                    System.out.println("choix invalide");
            }

        }while (true);

    }

    private static void gestionProduit(IMetier<Produit> mp) throws IOException, ClassNotFoundException {
        boolean quit = false;
        do {
            menuProduit();
            System.out.println("entrez votre choix: ");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("la list des Clients");
                    if (mp.getAll() == null) {
                        System.out.println("la liste est vide");
                    } else {
                        mp.getAll().forEach(p -> System.out.println(p.myToString()));
                    }


                    break;
                case 2:
                    System.out.println("entrez l' id de client à rechercher: ");
                    long searchId = sc.nextLong();
                    Produit p = mp.findById(searchId);
                    System.out.println(p.myToString());

                    break;
                case 3:
                    System.out.println("entrez le id du produit: ");
                    long id = sc.nextLong();
                    System.out.println("entrez le nom du produit: ");
                    String nom = sc.next();
                    System.out.println("entrez la marque du produit: ");
                    String marque = sc.next();
                    System.out.println("entrez le prix du produit: ");
                    double prix = sc.nextDouble();
                    System.out.println("entrez la description du produit: ");
                    String description = sc.next();
                    System.out.println("entrez la quantité du produit: ");
                    int quantite = sc.nextInt();
                    Produit produit = new Produit(id, nom, marque, prix, description, quantite);
                    mp.add(produit);

                    break;

                case 4:

                    System.out.println("entrez le id du client à supprimer: ");
                    long idProduit = sc.nextLong();
                    mp.delete(idProduit);


                    break;
                case 5:
                    mp.saveAll();
                    System.out.println("les produits sont sauvegardés");
                    break;
                case 6:
                    System.out.println("Au revoir");
                    quit = true;
                    break;
                default:
                    System.out.println("choix invalide");
                    break;
            }
        } while (!quit);
    }

    private static void gestionClient(IMetier<Client> ml) throws IOException, ClassNotFoundException {
        boolean quit = false;
        do {

            menuClient();
            System.out.println("entrez votre choix: ");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("la list des Clients");
                    if (ml.getAll() == null) {
                        System.out.println("la liste est vide");
                    } else {
                        ml.getAll().forEach(client -> System.out.println(client.myToString()));
                    }


                    break;
                case 2:
                    System.out.println("entrez l' id de client à rechercher: ");
                    long searchId = sc.nextLong();
                    Client client = ml.findById(searchId);
                    System.out.println(client.myToString());

                    break;
                case 3:

                    System.out.println("entrez le id du client: ");
                    long id = sc.nextLong();
                    System.out.println("entrez le nom du client: ");
                    String nom = sc.next();
                    System.out.println("entrez le numéro du client: ");
                    String numero = sc.next();
                    System.out.println("entrez le prenom du client: ");
                    String prenom = sc.next();
                    System.out.println("entrez l'adresse du client: ");
                    String adresse = sc.next();
                    System.out.println("entrez l'email du client: ");
                    String email = sc.next();
                    ml.add(new Client(id, nom, numero, prenom, adresse, email));

                    break;

                case 4:

                    System.out.println("entrez le id du client à supprimer: ");
                    long idClient = sc.nextLong();
                    ml.delete(idClient);


                    break;
                case 5:
                    ml.saveAll();
                    System.out.println("les clients sont sauvegardés");
                    break;
                case 6:
                    System.out.println("Au revoir");
                    quit = true;
                    break ;
                default:
                    System.out.println("choix invalide");
                    break;
            }
        } while (!quit);
    }

    public static void menu() {
        System.out.println("1. gestion de clients");
        System.out.println("2. gestion de produits");
        System.out.println("3. quitter");
    }
    public static void menuClient() {
        System.out.println("1. Afficher la liste des clients.\n" +
                "2. Afficher un client par son id.\n" +
                "3. Ajouter un nouveau client dans la liste.\n" +
                "4. Supprimer un client par id.\n" +
                "5. Sauvegarder les clients : cette option permet de sauvegarder la liste des\n" +
                "clients dans fichier nommé clients.dat.\n" +
                "6. Quitter ce programme.");
    }

    public static void menuProduit() {
        System.out.println("1. Afficher la liste des produits.\n" +
                "2. Afficher un produit par son id.\n" +
                "3. Ajouter un nouveau produit dans la liste.\n" +
                "4. Supprimer un produit par id.\n" +
                "5. Sauvegarder les produits : cette option permet de sauvegarder la liste des\n" +
                "produits dans fichier nommé produits.dat.\n" +
                "6. Quitter ce programme.");
    }

}