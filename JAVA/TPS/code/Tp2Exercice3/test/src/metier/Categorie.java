package metier;

import java.util.List;

public class Categorie {
    private String nom;
    private String description;
    List<Ordinateur> ordinateurs;

    public void ajouterOrdinateur(Ordinateur ordinateur) {
        if (ordinateurs.contains(ordinateur)) {
            ordinateurs.add(new Ordinateur("nom", "marque", 100.0, "description"));
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
}
