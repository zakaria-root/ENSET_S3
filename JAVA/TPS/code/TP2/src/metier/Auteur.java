package metier;

public class Auteur extends Personne {
    private static int numAuteur=0;

    public Auteur(String nom, String prenom, String email, double tel, int age) {
        super(nom, prenom, email, tel, age);
        numAuteur++;
    }

    public void afficher(){
        super.afficher();
        System.out.println(", numAutheur: "+numAuteur);
    }
}
