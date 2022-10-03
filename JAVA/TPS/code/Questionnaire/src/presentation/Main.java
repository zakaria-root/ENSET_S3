package presentation;

import metier.Questionnaire;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Questionnaire questionnaire;
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le titre deu  questionnaire :");
        String title = sc.nextLine();
        System.out.println("entrer le nombre des questions du questionnaire :");
        questionnaire = new Questionnaire(title, sc.nextInt());
        questionnaire.saisire();
        questionnaire.jouer();
        questionnaire.resulta();

    }
}