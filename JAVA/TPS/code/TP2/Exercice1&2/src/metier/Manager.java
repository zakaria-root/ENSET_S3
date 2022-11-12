package metier;

public class Manager extends Employee {
    private String service;
    public Manager(String service) {
        this.service = service;
    }
    public Manager(String nom, String prenom, String email, double telephone, double salaire, String service) {
        super(nom, prenom, email, telephone, salaire);
        this.service = service;
    }
    @Override
    public String toString() {
        return "Manager{" +
                "Ingenieur{" +
                "nom='" + nom+ '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", service='" + service + '\'' +
                ", salaire=" + salaire +
                '}';
    }
    public void afficher(){
        System.out.println(toString());
    }

    @Override
    public double calculerSalire() {
        return salaire + salaire * .20;
    }
}
