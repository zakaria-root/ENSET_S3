package metier;

import java.util.List;

public interface ICabinetMetier {

    public List<Consultation> getConsultationsMedcin(int id);
    public void ajouterPaient(Patient p);
    public void ajouterMedcin(Medecin m);
    public void ajouterConsultation(Consultation c);
    public void supprimerPatient(int id);
    public void supprimerMedecin(int id);
    public void supprimerConsultation(int id);
    public List<Patient> getPatientsParNom(String name);
    public List<Patient> getPatients();
    public List<Medecin> getMedecins();
    public List<Consultation> getConsultations();
}
