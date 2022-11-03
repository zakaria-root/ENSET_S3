package presentation;

import metier.BD.BDInteraction;
import metier.CabinetMetier;
import metier.Consultation;
import metier.Medecin;
import metier.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static CabinetMetier cabinetMetier = new CabinetMetier();

    public static void main(String[] args) throws ParseException {
        doneeinitiation();
        boolean quite = false;
        do {
            menue();
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    gestionDuPatients();
                    break;
                case 2:
                    gestionDuMedecin();
                    break;
                case 3:
                    gestionDuConsultation();
                    break;
                case 4:
                    System.out.println("Au revoir");
                    quite = true;
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (quite == false);


    }

    private static void gestionDuPatients() throws ParseException {
        boolean quite;
        do {
            quite = false;
            pateintMenue();
            System.out.println("entre votre choix");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("la liste des patients :");
                    System.out.println("-----------------------");
                    if (cabinetMetier.getPatients().size() == 0) {
                        System.out.println("aucun patient");
                    } else {
                        cabinetMetier.getPatients().forEach(System.out::println);
                    }

                    break;
                case 2:
                    System.out.println("Rechercher des patients par mot Clé :");
                    System.out.println("-------------------------------------");
                    System.out.println("entre le nom du patient");
                    String nom = sc.next();
                    if (cabinetMetier.getPatientsParNom(nom).size() == 0) {
                        System.out.println("aucun patient");
                    } else {
                        cabinetMetier.getPatientsParNom(nom).forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.println("L'ajoute d'un pation :");
                    System.out.println("----------------------");
                    System.out.println("entre l'id du patient");
                    int id_patient = sc.nextInt();
                    System.out.println("entre le nom du patient");
                    String nom1 = sc.next();
                    System.out.println("entre le prenom du patient");
                    String prenom = sc.next();
                    System.out.println("entre le cin du patient");
                    String cin = sc.next();
                    System.out.println("entre le telephone du patient");
                    String telephone = sc.next();
                    System.out.println("entre le email du patient");
                    String email = sc.next();
                    System.out.println("entre le date_naissance du patient");
                    String sDate1 = sc.next();
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                    Patient p1 = new Patient(id_patient, nom1, prenom, cin, telephone, email, date1, new ArrayList<>());
                    cabinetMetier.ajouterPaient(p1);

                    break;
                case 4:
                    System.out.println("Supprimer un patient :");
                    System.out.println("----------------------");
                    if (!cabinetMetier.getPatients().isEmpty()) {
                        System.out.println("entre l'id du patient");
                        int id_pation_rehercher = sc.nextInt();
                        cabinetMetier.supprimerPatient(id_pation_rehercher);
                    } else {
                        System.out.println("la liste des patients est vide");
                    }
                    break;
                case 5:
                    System.out.println("Afficher les consultations d'un patient :");
                    System.out.println("----------------------------------------");
                    System.out.println("entre l'id du patient");
                    int id_patient_rechercher = sc.nextInt();
                    if (cabinetMetier.getConsultationsPatient(id_patient_rechercher).size() == 0) {
                        System.out.println("aucune consultation");
                    } else {
                        cabinetMetier.getConsultationsPatient(id_patient_rechercher).forEach(System.out::println);
                    }
                    break;
                case 6:
                    quite = true;
                    break;
                default:
                    System.out.println("choix invalide");
            }


        } while (quite == false);
    }

    private static void gestionDuMedecin() throws ParseException {
        boolean quite;
        do {
            quite = false;
            medcineMenue();
            System.out.println("entre votre choix");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("L'ajoute d'un medecins :");
                    System.out.println("----------------------");
                    System.out.println("entre l'id du medecins");
                    int id_medecin = sc.nextInt();
                    System.out.println("entre le nom du medecins");
                    String nom1 = sc.next();
                    System.out.println("entre le prenom du medecins");
                    String prenom = sc.next();
                    System.out.println("entre le cin du medecins");
                    String cin = sc.next();
                    System.out.println("entre le telephone du medecins");
                    String telephone = sc.next();
                    System.out.println("entre le email du medecins");
                    String email = sc.next();

                    Medecin mdecin = new Medecin(id_medecin, nom1, prenom, cin, telephone, email, new ArrayList<>());
                    cabinetMetier.ajouterMedcin(mdecin);
                    break;

                case 2:
                    System.out.println("la liste des medecins :");
                    System.out.println("-----------------------");
                    if (cabinetMetier.getPatients().size() == 0) {
                        System.out.println("aucun patient");
                    } else {
                        cabinetMetier.getMedecins().forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.println("Supprimer un medecinsmedecins :");
                    System.out.println("----------------------");
                    if (!cabinetMetier.getMedecins().isEmpty()) {
                        System.out.println("entre l'id du medecins");
                        int id_pation_rehercher = sc.nextInt();
                        cabinetMetier.supprimerMedecin(id_pation_rehercher);
                    } else {
                        System.out.println("la liste des medecins est vide");
                    }
                    break;
                case 4:
                    System.out.println("Afficher les consultqtions d'un medecins :");
                    System.out.println("----------------------------------------");
                    System.out.println("entre l'id du medecins");
                    int id_patient_rechercher = sc.nextInt();
                    if (cabinetMetier.getConsultationsMedcin(id_patient_rechercher).size() == 0) {
                        System.out.println("aucune consultation");
                    } else {
                        cabinetMetier.getConsultationsMedcin(id_patient_rechercher).forEach(System.out::println);
                    }
                    break;
                case 5:
                    quite = true;
                    break;
                default:
                    System.out.println("choix invalide");
            }


        } while (quite == false);
    }

    private static void gestionDuConsultation() throws ParseException {
        boolean quite;
        do {
            quite = false;
            consultationMenue();
            System.out.println("entre votre choix");
            int choix = sc.nextInt();
            switch (choix) {


                case 1:
                    System.out.println("L'ajoute d'un consultation :");
                    System.out.println("----------------------");
                    System.out.println("entre l'id du consultation");
                    int id_consultation = sc.nextInt();
                    System.out.println("entre l'id du patient");
                    int id_patient = sc.nextInt();
                    System.out.println("entre l'id du medecins");
                    int id_medecins = sc.nextInt();
                    System.out.println("entre le date du consultation");
                    String sDate1 = sc.next();
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                    if (cabinetMetier.getPatientParId(id_patient) != null && cabinetMetier.getMedecinParId(id_medecins) != null) {
                        Consultation consultation = new Consultation(id_consultation, date1, cabinetMetier.getPatientParId(id_patient), cabinetMetier.getMedecinParId(id_medecins));
                        cabinetMetier.ajouterConsultation(consultation);
                        cabinetMetier.getPatientParId(id_patient).getConsultation().add(consultation);
                        cabinetMetier.getMedecinParId(id_medecins).getConsultations().add(consultation);
                    } else {
                        System.out.println("le patient ou le medecins n'existe pas");
                    }


                    break;
                case 2:
                    System.out.println("la list des consultations :");
                    System.out.println("----------------------");
                    cabinetMetier.getConsultations().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("la suppresion d'un consultation :");
                    System.out.println("----------------------------------------");
                    System.out.println("entre l'id du consultation");
                    int id_consultation_rechercher = sc.nextInt();
                    cabinetMetier.supprimerConsultation(id_consultation_rechercher);
                    if (cabinetMetier.getPatientParId(id_consultation_rechercher) != null && cabinetMetier.getMedecinParId(id_consultation_rechercher) != null) {
                        cabinetMetier.getPatientParId(id_consultation_rechercher).getConsultation().remove(id_consultation_rechercher);
                        cabinetMetier.getMedecinParId(id_consultation_rechercher).getConsultations().remove(id_consultation_rechercher);
                    } else {
                        System.out.println("il n'ya pas de consultation de ce patient ou de ce medecins");
                    }

                    break;
                case 4:
                    quite = true;
                    break;
                default:
                    System.out.println("choix invalide");
            }


        } while (quite == false);
    }


    private static void doneeinitiation() {
        BDInteraction.connect();
        BDInteraction.edit("delete from consultation ");

        BDInteraction.edit("delete from medecins");
        BDInteraction.edit("delete from patients");
        BDInteraction.close();
        List<Consultation> consultations = new ArrayList<>();
        Patient p1 = new Patient(2, "Doe", "John", "123456", "0606060606", "sadak@gmail.com", new Date(), new ArrayList<>());
        Patient p2 = new Patient(6, "Doe", "Jane", "123456", "0606060606", "dasd@gamil.com", new Date(), new ArrayList<>());
        Patient p3 = new Patient(4, "Doe", "Jack", "123456", "0606060606", "djhsak@g,amil.com", new Date(), new ArrayList<>());

        Medecin medecin = new Medecin(3, "Doe", "John", "123456", "0606060606", "sahksa@gamil.com", new ArrayList<>());
        Consultation consultation1 = new Consultation(5, new Date(), p1, medecin);
        Consultation consultation2 = new Consultation(7, new Date(), p2, medecin);
        Consultation consultation3 = new Consultation(8, new Date(), p3, medecin);


        consultations.add(consultation1);
        consultations.add(consultation2);
        consultations.add(consultation3);
        medecin.setConsultations(consultations);
        cabinetMetier.ajouterMedcin(medecin);
        p1.getConsultation().add(consultation1);
        p2.getConsultation().add(consultation2);
        p3.getConsultation().add(consultation3);
        cabinetMetier.ajouterPaient(p1);
        cabinetMetier.ajouterPaient(p2);
        cabinetMetier.ajouterPaient(p3);
        cabinetMetier.ajouterConsultation(consultation1);
        cabinetMetier.ajouterConsultation(consultation2);
        cabinetMetier.ajouterConsultation(consultation3);
    }

    public static void pateintMenue() {
        System.out.println("----------------------------");
        System.out.println("1. Afficher la liste des patients\n" +
                "2. Rechercher des patients par mot Clé.\n" +
                "3. Ajouter un patient.\n" +
                "4. Supprimer un patient.\n" +
                "5. Afficher la liste des consultations d’un patient.\n" +
                "6. Quitter");
        System.out.println("----------------------------");
    }

    public static void medcineMenue() {
        System.out.println("----------------------------");
        System.out.println("1. Ajouter un médecin.\n" +
                "2. Afficher la liste des médecins.\n" +
                "3. Supprimer un médecin.\n" +
                "4. Afficher la liste des consultations données par un médecin.\n" +
                "5. Quiter");
        System.out.println("----------------------------");
    }

    public static void consultationMenue() {
        System.out.println("----------------------------");
        System.out.println("1. Ajouter une consultation .\n" +
                "2. Afficher la liste des consultations.\n" +
                "3. Supprimer une consultation.\n" +
                "4. Quitter");

        System.out.println("----------------------------");
    }

    public static void menue() {
        System.out.println("----------------------------");
        System.out.println("*** Bienvenue dans notre cabinet ***");

        System.out.println("1. Gestion des patients\n" +
                "2. Gestion des médecins\n" +
                "3. Gestion des consultations\n" +
                "4. Quitter");

        System.out.println("----------------------------");

    }

}