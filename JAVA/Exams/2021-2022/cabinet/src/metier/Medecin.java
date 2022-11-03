package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Medecin {
    private int id_medecin;
   private  String nom;
   private  String prenom;
   private  String cin;
   private  String tel;
   private  String email;

   private List<Consultation> consultations;

    public Medecin() {
         consultations = new ArrayList<>();
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Medecin(int id_medecin, String nom, String prenom, String cin, String tel, String email, List<Consultation> consultations) {
        this.id_medecin = id_medecin;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.tel = tel;
        this.email = email;
        this.consultations = consultations;
    }

    @Override
    public String toString() {
        return "Medecin : " + id_medecin +
                "\n----------------"+
                "\n nom ='" + nom + '\'' +
                "\n prenom ='" + prenom + '\'' +
                "\n cin ='" + cin + '\'' +
                "\n tel ='" + tel + '\'' +
                "\n email ='" + email + '\'' +
                "\n les consultations " +
                "\n---------------------"
                + (consultations.isEmpty()?"\n aucune consultation":(consultations.stream().map(c->c.toString()).reduce("",(a,b)->a+b)));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medecin medecin = (Medecin) o;
        return id_medecin == medecin.id_medecin && Objects.equals(nom, medecin.nom) && Objects.equals(prenom, medecin.prenom) && Objects.equals(cin, medecin.cin) && Objects.equals(tel, medecin.tel) && Objects.equals(email, medecin.email) && Objects.equals(consultations, medecin.consultations);
    }


}
