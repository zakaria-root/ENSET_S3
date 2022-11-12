package metier;

import metier.BD.BDInteraction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CabinetMetier implements ICabinetMetier {

    private List<Patient> patients;
    private List<Medecin> medecins;
    private List<Consultation> consultations;

    public CabinetMetier() {
        patients = new ArrayList<Patient>();
        medecins = new ArrayList<Medecin>();
        consultations = new ArrayList<Consultation>();
    }


    public List<Patient> getPatients() {
        BDInteraction.connect();
        ResultSet rs = BDInteraction.select("SELECT * FROM patients");
        try {
            while (rs.next()) {
                Patient p = new Patient();
                p.setId_patient(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setCin(rs.getString("cin"));
                p.setTelephone(rs.getString("telephone"));
                p.setEmail(rs.getString("email"));
                p.setDate_naissance(rs.getDate("date_naissence"));

//                if (getPatientParId(p.getId_patient()) == null) {
//                    patients.add(p);
//                }
                    patients.removeIf(p1 -> p1.getId_patient() == p.getId_patient());
                    patients.add(p);


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        rs = BDInteraction.select("SELECT * FROM consultation");
        try {
            while (rs.next()) {
                Consultation c = new Consultation();
                c.setId_consultation(rs.getInt("id"));
                int id_patient = rs.getInt("patient_id");
                int id_medecin = rs.getInt("medecin_id");
                c.setPatient(getPatientParId(id_patient));
                c.setMedecin(getMedecinParId(id_medecin));
                patients.stream().filter(p -> p.getId_patient() == id_patient).forEach(p -> p.getConsultation().add(c));
                medecins.stream().filter(m -> m.getId_medecin() == id_medecin).forEach(m -> m.getConsultations().add(c));
                c.setDate_consultation(rs.getDate("date_consultation"));


                consultations.removeIf(c1 -> c1.getId_consultation() == c.getId_consultation());
                consultations.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        BDInteraction.close();
        return this.patients;
    }

    public List<Medecin> getAllMedecins() {
        return medecins;
    }


    public List<Consultation> getConsultations() {
        BDInteraction.connect();
        ResultSet rs = BDInteraction.select("SELECT * FROM consultation");
        try {
            while (rs.next()) {
                Consultation c = new Consultation();
                c.setId_consultation(rs.getInt("id"));
                int id_patient = rs.getInt("patient_id");
                int id_medecin = rs.getInt("medecin_id");
                c.setPatient(getPatientParId(id_patient));
                c.setMedecin(getMedecinParId(id_medecin));
                getPatientParId(id_patient).getConsultation().add(c);
                getMedecinParId(id_medecin).getConsultations().add(c);
                c.setDate_consultation(rs.getDate("date_consultation"));
                Consultation consultation_exist = null;

                for (Consultation c1 : consultations) {
                    if (c1.getId_consultation() == c.getId_consultation()) {
                        consultation_exist = c1;
                    }
                }
                if (consultation_exist == null) {
                    consultations.add(c);
                } else {
                    consultations.set(consultations.indexOf(consultation_exist), c);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }


    public void ajouterPaient(Patient p) {
        Patient patient_exist = getPatientParId(p.getId_patient());
        if (patient_exist != null) {
            System.out.println("le patient existe deja");
        } else {
            if (patients.add(p)) {
                BDInteraction.connect();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
                String date = formatter.format(p.getDate_naissance());
                java.util.Date dateStr = null;
                try {
                    dateStr = formatter.parse(String.valueOf(date));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

                BDInteraction.edit("INSERT INTO patients (id, nom, prenom, cin, telephone, email, date_naissence) VALUES ('" + p.getId_patient() + "', '" + p.getNom() + "', '" + p.getPrenom() + "', '" + p.getCin() + "', '" + p.getTelephone() + "', '" + p.getEmail() + "', '" + dateDB + "')");
                BDInteraction.close();
                System.out.println("le patient a été ajouté avec succés");
            } else {
                System.out.println("le patient n'a pas été ajouté");
            }

        }
    }

    public void ajouterMedcin(Medecin m) {

        Medecin medcin_exist = getMedecinParId(m.getId_medecin());

        if (medcin_exist != null) {
            System.out.println("le medcin existe deja");
        } else {
            if (medecins.add(m)) {
                BDInteraction.connect();
                BDInteraction.edit("INSERT INTO medecins (id, nom, prenom, cin, telephone, email) VALUES ('" + m.getId_medecin() + "', '" + m.getNom() + "', '" + m.getPrenom() + "', '" + m.getCin() + "', '" + m.getTel() + "', '" + m.getEmail() + "')");
                BDInteraction.close();
                System.out.println("le medcin a été ajouté avec succés");
            } else {
                System.out.println("le medcin n'a pas été ajouté");
            }

        }
    }

    public void ajouterConsultation(Consultation c) {
        BDInteraction.connect();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        String date = formatter.format(c.getDate_consultation());
        java.util.Date dateStr = null;
        try {
            dateStr = formatter.parse(String.valueOf(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        BDInteraction.edit("INSERT INTO consultation (id, patient_id, medecin_id, date_consultation) VALUES ('" + c.getId_consultation() + "', '" + c.getPatient().getId_patient() + "', '" + c.getMedecin().getId_medecin() + "', '" + dateDB + "')");
        BDInteraction.close();
        consultations.add(c);
    }

    public void supprimerPatient(int id) {
        boolean patient_exist1 = false;
        for (Patient p : patients) {
            if (p.getId_patient() == id) {
                patient_exist1 = true;
                break;
            }
        }
        if (patient_exist1)
            if (patients.removeIf(p -> p.getId_patient() == id)) {
                BDInteraction.connect();
                BDInteraction.edit("DELETE FROM patients WHERE id = '" + id + "'");
                BDInteraction.close();
                System.out.println("le patient a été supprimé avec succés");
            } else {

                System.out.println("le patient n'a pas été supprimé");
            }
        else {
            System.out.println("le patient n'existe pas");
        }
    }

    public void supprimerMedecin(int id) {
        boolean medecin_exist = false;
        for (Medecin m : medecins) {
            if (m.getId_medecin() == id) {
                medecin_exist = true;
                break;
            }
        }
        if (medecin_exist)
            if (medecins.removeIf(m -> m.getId_medecin() == id)) {
                BDInteraction.connect();
                BDInteraction.edit("DELETE FROM medecins WHERE id = '" + id + "'");
                BDInteraction.close();
                System.out.println("le medecin a été supprimé avec succés");
            } else {
                System.out.println("le medecin n'a pas été supprimé");
            }
        else {
            System.out.println("le medecin n'existe pas");
        }
    }

    public void supprimerConsultation(int id) {
        boolean consultation_exist = false;
        for (Consultation c : consultations) {
            if (c.getId_consultation() == id) {
                consultation_exist = true;
                break;
            }
        }
        if (consultation_exist)
            if (consultations.removeIf(c -> c.getId_consultation() == id)) {
                BDInteraction.connect();
                BDInteraction.edit("DELETE FROM consultations WHERE id = '" + id + "'");
                BDInteraction.close();
                System.out.println("la consultation a été supprimé avec succés");
            } else {
                System.out.println("la consultation n'a pas été supprimé");
            }
        else {
            System.out.println("la consultation n'existe pas");
        }
    }

    public List<Patient> getPatientsParNom(String name) {
        BDInteraction.connect();
        ResultSet rs = BDInteraction.select("SELECT * FROM patients WHERE nom LIKE '%" + name + "%'");
        if (rs != null) {
            List<Patient> patientsParNom = new ArrayList<>();
            try {
                while (rs.next()) {
                    Patient p = new Patient(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("telephone"), rs.getString("email"), rs.getDate("date_naissence"), new ArrayList<>());
                    patientsParNom.add(p);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return patientsParNom;
        }
BDInteraction.close();
        return null;
    }


    public List<Medecin> getMedecins() {
        BDInteraction.connect();

        ResultSet rs = BDInteraction.select("SELECT * FROM medecins");
        try {
            while (rs.next()) {
                Medecin m = new Medecin(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("telephone"), rs.getString("email"), new ArrayList<>());

                medecins.removeIf(m1 -> m1.getId_medecin() == m.getId_medecin());
                medecins.add(m);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs = BDInteraction.select("SELECT * FROM consultation");
        try {
            while (rs.next()) {
                Consultation c = new Consultation();
                c.setId_consultation(rs.getInt("id"));
                int id_patient = rs.getInt("patient_id");
                int id_medecin = rs.getInt("medecin_id");
                c.setPatient(getPatientParId(id_patient));
                c.setMedecin(getMedecinParId(id_medecin));
                patients.stream().filter(p -> p.getId_patient() == id_patient).forEach(p -> p.getConsultation().add(c));
                medecins.stream().filter(m -> m.getId_medecin() == id_medecin).forEach(m -> m.getConsultations().add(c));


                c.setDate_consultation(rs.getDate("date_consultation"));

                consultations.removeIf(c1 -> c1.getId_consultation() == c.getId_consultation());
                consultations.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        BDInteraction.close();
        return medecins;

    }


    public List<Consultation> getConsultationsPatient(int id) {
        boolean patient_exist = false;
        for (Patient p : patients) {
            if (p.getId_patient() == id) {
                patient_exist = true;
                break;
            }
        }
        if (patient_exist) {
            for (Patient p : patients) {
                if (p.getId_patient() == id) {
                    return p.getConsultation();
                }
            }
        } else {
            System.out.println("le patient n'existe pas");
        }
        return new ArrayList<>();

    }

    @Override
    public List<Consultation> getConsultationsMedcin(int id) {
        boolean medcin_exist = false;
        for (Medecin m : medecins) {
            if (m.getId_medecin() == id) {
                medcin_exist = true;
                break;
            }
        }
        if (medcin_exist) {
            for (Medecin m : medecins) {
                if (m.getId_medecin() == id) {
                    return m.getConsultations();
                }
            }
        } else {
            System.out.println("le medcin n'existe pas");
        }
        return new ArrayList<>();

    }

    public Patient getPatientParId(int id_patient) {
        BDInteraction.connect();
        ResultSet rs = BDInteraction.select("SELECT * FROM patients WHERE id = '" + id_patient + "'");
        try {
            while (rs.next()) {
                Patient p = new Patient(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("telephone"), rs.getString("email"), rs.getDate("date_naissence"), new ArrayList<>());
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BDInteraction.close();
        System.out.println("le patient n'existe pas");
        return null;
    }

    public Medecin getMedecinParId(int id_medecin) {
        BDInteraction.connect();
        ResultSet rs = BDInteraction.select("SELECT * FROM medecins WHERE id = '" + id_medecin + "'");
        try {
            while (rs.next()) {
                Medecin m = new Medecin(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("telephone"), rs.getString("email"), new ArrayList<>());
                return m;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        BDInteraction.close();
        System.out.println("le patient n'existe pas");
        return null;
    }


    public Consultation getConsultatoinParId(int id) {
        BDInteraction.connect();
        ResultSet rs = BDInteraction.select("SELECT * FROM consultation WHERE id = '" + id + "'");
        try {
            if (rs.next()) {
                Consultation c = new Consultation();
                c.setId_consultation(rs.getInt("id"));
                int id_patient = rs.getInt("patient_id");
                int id_medecin = rs.getInt("medecin_id");
                c.setPatient(getPatientParId(id_patient));
                c.setMedecin(getMedecinParId(id_medecin));
                getPatientParId(id_patient).getConsultation().add(c);
                getMedecinParId(id_medecin).getConsultations().add(c);
                c.setDate_consultation(rs.getDate("date_consultation"));
                return c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        BDInteraction.close();
        return null;
    }

}
