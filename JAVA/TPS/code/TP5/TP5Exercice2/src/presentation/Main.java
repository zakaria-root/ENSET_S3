package presentation;

import metier.DosierContact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

import static java.lang.System.exit;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static DosierContact dc;



    public static void main(String[] args) throws IOException {
        dc = new DosierContact(new ArrayList<String>(), new ArrayList<String>());
        dc.ajouterContact("Moussa", "123456789");
        dc.ajouterContact("Moussa1", "123456789");
        dc.ajouterContact("Moussa2", "123456789");
        dc.ajouterContact("Moussa3", "123456789");

        do {
            menu();
            System.out.println("entrez votre choix: ");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("entrez le nom du contact à rechercher: ");
                    String nomARechercher = sc.next();
                    dc.rechercherContact(nomARechercher);
                    break;
                case 2:
                    System.out.println("entrez le nom du contact: ");
                    String nom = sc.next();
                    System.out.println("entrez le numéro du contact: ");
                    String numero = sc.next();

                    dc.ajouterContact(nom, numero);

                    break;
                case 3:
                    System.out.println("entrez le nom du contact à supprimer: ");
                    String nomASupprimer = sc.next();
                    dc.supprimerContact(nomASupprimer);

                case 4:
                    System.out.println("entrez le nom du contact à modifier: ");
                    String nomAModifier = sc.next();
                    System.out.println("entrez le nouveau numéro du contact: ");
                    String nouveauNumero = sc.nextLine();
                    dc.modifierNumeroContact(nomAModifier, nouveauNumero);
                    break;
                case 5:
                    dc.afficherTousLesContacts();
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
        System.out.println("1- Rechercher un numro de telephone");
        System.out.println("2. Ajouter un contact");
        System.out.println("3. Supprimer un contact");
        System.out.println("4. Changer le numéro d’un contact");
        System.out.println("5. Afficher tous les contacts");
        System.out.println("6. Quitter");
    }



}
