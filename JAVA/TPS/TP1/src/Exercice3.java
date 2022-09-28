import java.util.Scanner;

public class Exercice3 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int nb;
        StringBuilder chaine = new StringBuilder("");
        do {

            nb = menue(sc);
            switch (nb) {
                case 1:
                    System.out.println("saisire une chaine de carachtaire: ");
                    sc.nextLine();
                    chaine.delete(0, chaine.length());
                    chaine.append(sc.nextLine());
                    break;
                case 2:
                    System.out.println(chaine);
                    break;
                case 3:
                    chaine.reverse();
                case 4:
                    int nbMote = chaine.toString().split(" ").length;
                    System.out.println("le nombre des mote du '" + chaine + "' est : " + nbMote);
                    break;
                case 5:
                    break;
            }

        } while (nb != 5);
    }

    private static int menue(Scanner sc) {
        int nb;
        System.out.println("1. saisir ");
        System.out.println("2. afficher ");
        System.out.println("3. inverser ");
        System.out.println("4. Nombre de mots ");
        System.out.println("5. quiter ");
        System.out.println("choisir un nombre: ");
        nb = sc.nextInt();
        System.out.println("-------------------");
        return nb;
    }
}
