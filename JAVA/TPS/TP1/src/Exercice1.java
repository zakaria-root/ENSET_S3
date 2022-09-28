import java.util.Arrays;
import java.util.Scanner;

public class Exercice1 {

    public static void run(){
        double[] notes ;
        Scanner sc = new Scanner(System.in);

        notes = insereEtudiant(sc);
        System.out.println("les notes avant le sort");
        afficherNotes(notes);
        System.out.println("les notes apres le sort");
        Arrays.sort(notes);
        afficherNotes(notes);
        double avgNotes = getAvgNotes(notes);
        System.out.println("la moyene des notes est : " + avgNotes / notes.length);
        double maxNote = getMaxNote(notes);
        System.out.println("la notes max est :" + maxNote);
        double minNote = getMinNote(notes);
        System.out.println("la notes max est :" + minNote);

        System.out.println("le nombre doccurance d'une note :");
        OccEtudiant(sc, notes);

        System.out.println("FIN DE PROGRAMME ...");
    }

    private static double[] insereEtudiant(Scanner sc) {
        double[] notes;
        System.out.println("entrer le nombre des etdiant");
        int nb = Integer.parseInt(sc.nextLine());

        notes = new double[nb];
        for (int i = 1; i <= nb; i++) {
            double note;
            do {

                System.out.println("entrer la note de lutidiant numero " + i);
                note = Float.parseFloat(sc.nextLine());
            } while (note > 20 || note < 0);
            notes[i - 1] = note;
        }
        return notes;
    }

    private static void OccEtudiant(Scanner sc, double[] notes) {
        System.out.println("entrer une note ");
        double noteEtudiant = Float.parseFloat(sc.nextLine());
        int nbOcc = 0;
        for (double note : notes) {
            if (note == noteEtudiant) {
                nbOcc++;
            }
        }
        System.out.println("le nombre d’étudiants ayant la note " + noteEtudiant + " est : " + nbOcc);
    }

    private static double getMinNote(double[] notes) {
        double minNote = notes[0];
        for (double note : notes) {
            if (minNote > note) {
                minNote = note;
            }
        }
        return minNote;
    }

    private static double getMaxNote(double[] notes) {
        double maxNote = notes[0];
        for (double note : notes) {
            if (maxNote < note) {
                maxNote = note;
            }
        }
        return maxNote;
    }

    private static double getAvgNotes(double[] notes) {
        double avgNotes = 0;
        for (double note : notes) {
            avgNotes += note;
        }
        return avgNotes;
    }

    private static void afficherNotes(double[] notes) {
        for (double note : notes) {
            System.out.print(note);
            System.out.print(" ,");
        }
    }

}
