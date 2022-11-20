package metier;

import java.io.Serializable;
import java.util.Objects;

public class Produit implements Serializable {
    private long id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombre;

    public Produit() {
    }



    public Produit(long id, String nom, String marque, double prix, String description, int nombre) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombre = nombre;
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

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id == produit.id && Double.compare(produit.prix, prix) == 0 && nombre == produit.nombre && Objects.equals(nom, produit.nom) && Objects.equals(marque, produit.marque) && Objects.equals(description, produit.description);
    }


    public String myToString() {
        return "\nProduit " + id +
                "\n----------------" +
                "\nnom='" + nom + '\'' +
                "\nmarque='" + marque + '\'' +
                "\nprix=" + prix +
                "\ndescription='" + description + '\'' +
                "\nnombre=" + nombre ;
    }
}
