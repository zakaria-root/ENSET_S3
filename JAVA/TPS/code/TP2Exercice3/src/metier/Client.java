package metier;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private String telephone;


    private String email;
    List<Commande> commandes;

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }


    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client(String nom, String prenom, String adresse, String ville, String telephone, String email, List<Commande> commandes) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
        this.commandes =commandes;
    }

    public void ajouterCommande(Commande commande) {
        Boolean trouve = false;
        for (Commande c : commandes) {
            if (c.getReference() == commande.getReference()) {
                trouve = true;
                return;
            }
        }
            if (trouve) {
                System.out.println("La commande existe déjà");
            } else {
                commandes.add(commande);
            }

    }

    public void supprimerCommande(Commande commande) {
        if (commandes.contains(commande)) {
            System.out.println("la commande n'existe pas");
        } else {
            commandes.remove(commande);
        }
    }

    public  void afficher(){
        System.out.print(" |   nom de client   |   prenom  |   adresse  |   ville  |   telephone  |   email  |  " );
    }

    @Override
    public String toString() {
        return
                "   " + nom + '\'' +
                "   |   "+ prenom + '\'' +
                "   |   " + adresse + '\'' +
                "   |   "  + ville + '\'' +
                "   |   " + telephone + '\'' +
                "   |   " + email + '\'' ;
    }

}
