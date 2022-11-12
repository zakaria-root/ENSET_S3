package metier;

import java.util.List;

public class Ordinateur {
    private String nom;
    private String marque;
    private Double prix;
    private String description;
    List<LigneCommande> ligneCommandes;

    private Categorie categorie;


    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }
    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }
    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public Double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public static int getNombreOrdinateur() {
        return nombreOrdinateur;
    }

    static private int nombreOrdinateur = 0;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    public static void setNombreOrdinateur(int nombreOrdinateur) {
        Ordinateur.nombreOrdinateur = nombreOrdinateur;
    }

    public Ordinateur(String nom, String marque, Double prix, String description, List<LigneCommande> ligneCommandes, Categorie categorie) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.ligneCommandes = ligneCommandes;
        this.categorie = categorie;
        nombreOrdinateur++;
    }
    @Override
    public String toString() {
        return "  \nnom d'ordinateur :"+nom +
                " \nla marque d'ordinateur : " + marque +
                " \nle prix d'ordinateur : " + prix +
                " \nla description d'ordinateur : " + description +
                " \nle totale d'ordinateur : " + prixOrdinateurs() +
                "" + categorie ;
    }

    public double prixOrdinateurs() {
        double somePrix =0;
        for (LigneCommande ligne : ligneCommandes) {
            somePrix +=  ligne.getQuantite() * prix;
        }
        return somePrix;
    }
}
