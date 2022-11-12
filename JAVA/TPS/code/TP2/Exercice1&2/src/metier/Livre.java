package metier;

public class Livre {
    private int ISBN;
    private  Auteur auteur;
    public void afficher(){
        this.auteur.afficher();
        System.out.println("ISBN: "+ISBN);
    }

    public Livre(int ISBN, Auteur auteur) {
        this.ISBN = ISBN;
        this.auteur = auteur;
    }
}
