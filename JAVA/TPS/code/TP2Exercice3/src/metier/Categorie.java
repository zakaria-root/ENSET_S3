package metier;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private String nom;
    private String description;
    List<Ordinateur> ordinateurs;

    public Categorie(String nom, String description, List<Ordinateur> ordinateurs) {
        this.nom = nom;
        this.description = description;
        this.ordinateurs = ordinateurs;
    }

    public Categorie() {
    }

    public void ajouterOrdinateur(Ordinateur ordinateur) {
        if (ordinateurs.contains(ordinateur)) {
            ordinateurs.add(ordinateur);
        } else {
            System.out.println("l'ordinateur existe deja");
        }
    }

    public void supprimerOrdinateur(Ordinateur ordinateur) {
        if (ordinateurs.contains(ordinateur)) {
            ordinateurs.remove(ordinateur);
        } else {
            System.out.println("l'ordinateur n'existe pas");
        }

    }

    public Ordinateur rechercherParPrix(Double prix) {
        for (Ordinateur ordinateur : ordinateurs) {
            if (ordinateur.getPrix() == prix) {
                return ordinateur;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "" +
                "\nnom du categorie : " + nom + "    "+
                "\ndescription du categorie :   " + description ;
    }
}
