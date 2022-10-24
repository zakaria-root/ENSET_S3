package metier;

public class Ordinateur {
    private String nom;
    private String marque;
    private Double prix;
    private String description;

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

    public static void setNombreOrdinateur(int nombreOrdinateur) {
        Ordinateur.nombreOrdinateur = nombreOrdinateur;
    }

    public Ordinateur(String nom, String marque, Double prix, String description) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
    }

    public double prixOrdinateurs(){
        return nombreOrdinateur * prix;
    }
}
