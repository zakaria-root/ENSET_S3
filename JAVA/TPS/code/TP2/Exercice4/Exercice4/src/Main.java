import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static MetierProduitImpl metierProduit= new MetierProduitImpl(new ArrayList<>());
    private static Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) {
        metierProduit.add(new Produit(1, "Ordinateur", "HP", 1000, "Ordinateur portable", 10));
        metierProduit.add(new Produit(2, "Imprimante", "HP", 200, "Imprimante laser", 10));
        metierProduit.add(new Produit(3, "Smartphone", "Samsung", 500, "Smartphone 4G", 10));

        boolean quit;
        do {

            quit = false;
            menue();

            int choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("la liste des produits");
                    if (metierProduit.getAll().isEmpty()) {
                        System.out.println("la liste est vide");
                    } else {
                      metierProduit.getAll().forEach(p -> {
                            System.out.println(p);
                        });
                    }

                    break;
                case 2:
                    System.out.println("Rechercher des produits par mot clé");
                    System.out.println("Entrer le mot clé");
                    sc.nextLine();
                    String motCle = sc.nextLine();
                    System.out.println("la liste des produits de mot clé " + motCle);
                    System.out.println("----------------------------------");
                   metierProduit.findByNom(motCle).forEach(p -> {
                        System.out.println(p);
                    });

                    break;
                case 3:
                    System.out.println("Ajouter un nouveau produit dans la liste");
                    System.out.println("---------------------------------");
                    System.out.println("Entrer l'id de produit ");
                    long idProduit = sc.nextLong();
                    System.out.println("Entrer le nom du produit");
                    String nom = sc.next();
                    System.out.println("Entrer la marque du produit");
                    String marque = sc.next();
                    System.out.println("Entrer le prix du produit");
                    double prix = sc.nextDouble();
                    System.out.println("Entrer la description du produit");
                    String description = sc.next();
                    System.out.println("Entrer le nombre en stock du produit");
                    int nombreEnStock = sc.nextInt();
                    Produit p = new Produit(idProduit, nom, marque, prix, description, nombreEnStock);
                    metierProduit.add(p);
                    break;
                case 4:
                    System.out.println("Récupérer et afficher un produit par ID");
                    System.out.println("Entrer l'id du produit");
                    long findId = sc.nextLong();
                    Produit findProduit = metierProduit.findById(findId);
                    if (findProduit == null) {
                        System.out.println("le produit n'existe pas");
                    } else {
                        System.out.println(findProduit);
                    }
                    break;
                case 5:
                    System.out.println("Supprimer un produit par id");
                    System.out.println("Entrer l'id du produit");
                    if (metierProduit.getAll().isEmpty()) {
                        System.out.println("la liste est vide");
                    } else {
                        long deleteId = sc.nextLong();
                        if (metierProduit.findById(deleteId) == null) {
                            System.out.println("le produit n'existe pas");
                        } else {
                            metierProduit.delete(deleteId);
                        }
                    }

                    break;
                case 6:
                    System.out.println("aurevoir ...");
                    quit = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (quit != true);


    }

    private static void menue() {
        System.out.println("------------------------------------------------");
        System.out.println("menue");
        System.out.println(
                "1. Afficher la liste des produits.\n" +
                        "2. Rechercher des produits par mot clé.\n" +
                        "3. Ajouter un nouveau produit dans la liste.\n" +
                        "4. Récupérer et afficher un produit par ID.\n" +
                        "5. Supprimer un produit par id.\n"+
                        "6. Quitter le programme.\n"
        );
        System.out.println("------------------------------------------------");
    }
}