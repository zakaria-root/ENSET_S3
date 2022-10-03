import java.util.Scanner;

public class Exercice2 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        String verbe;
        String[] sufixes = {"e", "es", "e", "ons", "ez", "ent"};
        String[] prefix = {"je", "tu", "il", "nous", "vous", "ils"};


        verbe = saisireVerbe(sc);

        String verbeConjuguer = verbe.substring(0, verbe.length() - 2);

        for (int i = 0; i < sufixes.length; i++) {
            System.out.println(prefix[i] + " " + verbeConjuguer + sufixes[i]);
        }
    }

    private static String saisireVerbe(Scanner sc) {
        String verbe;
        do {
            System.out.println("Entrez un verbe du premier groupe: ");
            verbe = sc.nextLine();
        } while (!verbe.endsWith("er"));
        return verbe;
    }
}
