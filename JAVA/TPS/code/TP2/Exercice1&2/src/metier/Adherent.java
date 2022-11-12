package metier;

public class Adherent extends Personne {
    private static int numAdherent =0;

    public Adherent(String nom, String prenom, String email, double tel, int age) {
        super(nom, prenom, email, tel, age);
        numAdherent++;
    }

    public void afficher(){
        super.afficher();
        System.out.println(", numAdherent: "+numAdherent);
    }

}
