package metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Consultation {
    private int id_consultation;
    private Date date_consultation;

    private Patient patient;
    private Medecin medecin;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Consultation(int id_consultation, Date date_consultation, Patient patient, Medecin medecin) {
        this.id_consultation = id_consultation;
        this.date_consultation = date_consultation;
        this.patient = patient;
        this.medecin = medecin;
    }

    public Consultation() {
    }

    public int getId_consultation() {
        return id_consultation;
    }

    public void setId_consultation(int id_consultation) {
        this.id_consultation = id_consultation;
    }

    public Date getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd ");
        String strDate = dateFormat.format( date_consultation);
        return "\nConsultation : "+ id_consultation  +
                "\n------------------"+
                "\ndate de consultation : " + strDate ;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return id_consultation == that.id_consultation && Objects.equals(date_consultation, that.date_consultation) && Objects.equals(patient, that.patient) && Objects.equals(medecin, that.medecin);
    }

}
