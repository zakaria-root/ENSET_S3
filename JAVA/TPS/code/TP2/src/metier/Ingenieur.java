package metier;

public class Ingenieur extends Employee{
    private String specialite;
    @Override
    public double calculerSalire(){
        return salaire =salaire*.15;
    }
    public Ingenieur(String specialite) {
        this.specialite = specialite;
    }
    @Override
    public String toString() {
        return "Ingenieur{" +
                "nom='" + nom+ '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", specialite=" + specialite + '\'' +
                ", salaire=" + salaire +
                '}';
    }
    public void afficher(){

        System.out.println(toString());
    }
    public Ingenieur(String nom, String prenom, String email, double telephone, double salaire, String specialite) {
        super(nom, prenom, email, telephone, salaire);
        this.specialite = specialite;
    }
}
