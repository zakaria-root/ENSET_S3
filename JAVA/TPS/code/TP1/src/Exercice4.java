import java.util.Scanner;

public class Exercice4 {
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        int occs[];
        System.out.println("entrer une chaine :");
        String chaine = sc.nextLine();
        occs = new int[chaine.length()];

        for (int i = 0; i < chaine.length(); i++) {
            for (String ch : chaine.split("")) {
                if (ch.equalsIgnoreCase(chaine.charAt(i) + "")) {
                    occs[i] = occs[i] + 1;
                }
            }
        }

        for (int i = 0; i < chaine.length(); i++) {

            System.out.println(occs[i] + " fois la lettre '" + chaine.charAt(i) + "'");
        }
    }}
