package metier;

public class Personne {
    private String nom;
    private String prenom;
    private String email;
    private double tel;
    private int age;
    public Personne(String nom, String prenom, String email, double tel, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.age = age;
    }
    @Override
    public String toString() {
        return
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", age=" + age;
    }
    public void afficher() {
        System.out.print(toString());
    }
}
