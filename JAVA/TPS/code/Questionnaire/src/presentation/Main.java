package presentation;

import metier.Questionnaire;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Questionnaire questionnaire;
        Scanner sc = new Scanner(System.in);
        ArrayList<Questionnaire> questionnaires = new ArrayList<>();
        int choix;
        int QChoix;

        do {

            choix = menue(sc);
            switch (choix) {
                case 1:
                    if (questionnaires.isEmpty()) {
                        System.out.println("la list des questionnaires est vide ...");
                        break;
                    }
                    System.out.println("choisissez le questionnaire vous voulez passer :");
                    for (int i = 0; i < questionnaires.toArray().length; i++) {
                        System.out.println((i + 1) + ". " + questionnaires.get(i).getTitre());
                    }
                    do {
                        System.out.print("entrez votre choix : ");
                        QChoix = sc.nextInt();
                    } while (QChoix < 0 || QChoix > questionnaires.toArray().length);
                    questionnaires.get(QChoix-1).jouer();
                    questionnaires.get(QChoix-1).resulta();
                    break;
                case 2:
                    System.out.println("entrez le titre du  questionnaire :");
                    sc.nextLine();
                    String title = sc.nextLine();
                    int nbQst;
                    do {
                        System.out.println("entrer le nombre des questions du questionnaire (1-5):");
                        nbQst = sc.nextInt();
                    } while (nbQst > 5|| nbQst<=0);
                    questionnaire = new Questionnaire(title, nbQst);

                    questionnaire.saisire();
                    questionnaires.add(questionnaire);
                    break;
                case 3:
                    System.out.println("AU REVOIR ...");
                    break;
            }
        } while (choix != 3);


    }

    private static int menue(Scanner sc) {
        int choix;
        System.out.println("QUESTIONNAIRE ");
        System.out.println("--------------");
        System.out.println("1. Passer un questionnaire ");
        System.out.println("2. Cree un nouveau questionnaire ");
        System.out.println("3. Sortie. ");
        System.out.print("entrez votre choix : ");
        choix = sc.nextInt();
        return choix;
    }
}