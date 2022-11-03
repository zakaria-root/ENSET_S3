package metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Patient {
    private int id_patient;
    private String nom;
    private String prenom;
    private String cin;
    private String telephone;
    private String email;
    private Date date_naissance;

    private List<Consultation> consultations;

    public Patient() {
        consultations = new ArrayList<>();
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public List<Consultation> getConsultation() {
        return consultations;
    }

    public void setConsultation(List<Consultation> consultation) {
        this.consultations = consultation;
    }

    public Patient(int id_patient, String nom, String prenom, String cin, String telephone, String email, Date date_naissance, List<Consultation> consultation) {
        this.id_patient = id_patient;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.telephone = telephone;
        this.email = email;
        this.date_naissance = date_naissance;
        this.consultations = consultation;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd ");
        String strDate = dateFormat.format(date_naissance);

        return "Patient : " + id_patient +
                "\n---------------------" +
                "\n nom ='" + nom +
                "\n prenom ='" + prenom +
                "\n cin ='" + cin +
                "\n telephone ='" + telephone +
                "\n email ='" + email +
                "\n date de naissance = " + strDate +
                (consultations.isEmpty() ? "\n aucune consultation" : (consultations.stream().map(c->c.toString()).reduce("",(a,b)->a+b)));
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id_patient == patient.id_patient && Objects.equals(nom, patient.nom) && Objects.equals(prenom, patient.prenom) && Objects.equals(cin, patient.cin) && Objects.equals(telephone, patient.telephone) && Objects.equals(email, patient.email) && Objects.equals(date_naissance, patient.date_naissance) && Objects.equals(consultations, patient.consultations);
    }


}
