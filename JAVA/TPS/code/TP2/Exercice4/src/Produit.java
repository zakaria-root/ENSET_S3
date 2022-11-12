import java.util.Objects;

public class Produit {
    private long id;
    private String nom;
   private String marque;
   private double prix;
   private String description;
   private int nombreEnStock;


    public Produit(long id, String nom, String marque, double prix, String description, int nombreEnStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }

    public Produit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombreEnStock() {
        return nombreEnStock;
    }

    public void setNombreEnStock(int nombreEnStock) {
        this.nombreEnStock = nombreEnStock;
    }

    @Override
    public String toString() {
        return "Produit " +
                " id : " + id +
                "\n---------------"+
                "\nnom : '" + nom + '\'' +
                "\nmarque : '" + marque + '\'' +
                "\nprix : " + prix +
                "\ndescription : '" + description + '\'' +
                "\nquatite : " + nombreEnStock
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id == produit.id && Double.compare(produit.prix, prix) == 0 && nombreEnStock == produit.nombreEnStock && Objects.equals(nom, produit.nom) && Objects.equals(marque, produit.marque) && Objects.equals(description, produit.description);
    }


}
