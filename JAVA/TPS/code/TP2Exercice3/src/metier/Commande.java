package metier;


import java.util.Date;
import java.util.List;

public class Commande {
    private int reference;
    private Client client;
    private Date dateCommande;
    private String etatDeCommande;

    private List<LigneCommande> ligneCommandes;

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getEtatDeCommande() {
        return etatDeCommande;
    }

    public void setEtatDeCommande(String etatDeCommande) {
        this.etatDeCommande = etatDeCommande;
    }

    public void afficher() {
        System.out.print(" | reference  |     date de commande    | etat de commande | ");
        for (LigneCommande ligneCommande : ligneCommandes) {
            ligneCommande.afficher();
        }
        client.afficher();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (LigneCommande ligneCommande : ligneCommandes) {
            str.append(" | " + ligneCommande.toString());
        }
        return "\n   " + reference + "    " +
                "   |   " + dateCommande +
                "    |   " + etatDeCommande +

                str.toString() + "   |   " + client + '\'';

    }

//    public LigneCommande getLigneCommande() {
//        return ligneCommande;
//    }
//
//    public void setLigneCommande(LigneCommande ligneCommande) {
//        this.ligneCommande = ligneCommande;
//    }

    public Commande(int reference, Client client, Date dateCommande, String etatDeCommande, List<LigneCommande> ligneCommande) {
        this.reference = reference;
        this.client = client;
        this.dateCommande = dateCommande;
        this.etatDeCommande = etatDeCommande;
        this.ligneCommandes = ligneCommande;
    }

    public Commande() {
    }
}
