package presentation;

import metier.Client;
import metier.MetierClientImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME = "clients.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MetierClientImpl ml = new MetierClientImpl(new ArrayList<>(), FILE_NAME);
//        ml.addClient(new Client(1, "Moussa", "123456789", "anassi", "132123122", "dada@gmail.com"));
//        ml.addClient(new Client(2, "Moussa1", "123456789", "anassi", "132123122", "dsadas@gmail.com"));
//        ml.addClient(new Client(3, "Moussa2", "123456789", "anassi", "132123122", "sdad@gmail.cpm"));

        do {
            menu();
            System.out.println("entrez votre choix: ");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("la list des Clients");
                    if (ml.getAllClients()==null) {
                        System.out.println("la liste est vide");
                    } else {
                        ml.getAllClients().forEach(client -> System.out.println(client.myToString()));
                    }


                    break;
                case 2:
                    System.out.println("entrez l' id de client à rechercher: ");
                    long searchId = sc.nextLong();
                    Client client = ml.findClinetById(searchId);
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
                    ml.addClient(new Client(id, nom, numero, prenom, adresse, email));

                    break;

                case 4:

                    System.out.println("entrez le id du client à supprimer: ");
                    long idClient = sc.nextLong();
                    ml.deleteClient(idClient);


                    break;
                case 5:
                    ml.saveAllClients();
                    System.out.println("les clients sont sauvegardés");
                    break;
                case 6:
                    System.out.println("Au revoir");
                    exit(1);
                    break;
                default:
                    System.out.println("choix invalide");
                    break;
            }
        } while (true);

    }

    public static void menu() {
        System.out.println("1. Afficher la liste des clients.\n" +
                "2. Afficher un client par son id.\n" +
                "3. Ajouter un nouveau client dans la liste.\n" +
                "4. Supprimer un client par id.\n" +
                "5. Sauvegarder les clients : cette option permet de sauvegarder la liste des\n" +
                "clients dans fichier nommé clients.dat.\n" +
                "6. Quitter ce programme.");
    }
}