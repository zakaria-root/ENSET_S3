package metier;

import com.sun.media.sound.WaveFloatFileReader;

public class LigneCommande {
    private int quantite;
    private Ordinateur ordinateur;
    private  Commande  commande;

    public int getQuantite() {
        return quantite;
    }

    public Ordinateur getOrdinateur() {
        return ordinateur;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setOrdinateur(Ordinateur ordinateur) {
        this.ordinateur = ordinateur;
    }

    public LigneCommande(int quantite, Ordinateur ordinateur, Commande commande) {
        this.quantite = quantite;
        this.ordinateur = ordinateur;
        this.commande = commande;
    }



    @Override
    public String toString() {
        return
                 "\nla quantite d'ordinateur : "+quantite +"    "+
                "" + ordinateur ;
    }
}
