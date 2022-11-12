package metier;

public abstract class Employee {
    protected String nom;
    protected String prenom;
    protected String email;
    protected double telephone;
    protected double salaire;

    public Employee() {
    }

    public Employee(String nom, String prenom, String email, double telephone, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.salaire = salaire;
    }
    public abstract double calculerSalire();
}
