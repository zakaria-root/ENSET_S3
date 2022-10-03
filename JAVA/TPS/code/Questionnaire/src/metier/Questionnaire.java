package metier;

import java.util.Scanner;

public class Questionnaire {
    private String titre;
    private Question[] questions;
    private int maxQSt;

    private int scoreTotale;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Question[] getQuestions() {
        return questions;
    }


    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public Questionnaire(String titre, int maxQSt) {
        this.titre = titre;
        this.questions = new Question[maxQSt];
        scoreTotale = 0;
        this.maxQSt = maxQSt;
    }

    public void saisire() {
        Scanner sc = new Scanner(System.in);
        Question qsCrr;
        Reponse repCrr;
        for (int i = 0; i < maxQSt; i++) {
            qsCrr = new Question();
            System.out.println("les information de la question n" + (i + 1));
            System.out.println("enter le titre ");
            qsCrr.setTitre(sc.nextLine());
            System.out.println("enter la description ");
            qsCrr.setDesc(sc.nextLine());
            System.out.println("enter le score ");
            qsCrr.setScore(sc.nextInt());
            System.out.println("enter les elements de reponse ");
            this.questions[i] = new Question(qsCrr.getTitre(), qsCrr.getDesc(), qsCrr.getScore());
            for (int j = 0; j < 3; j++) {
                repCrr = new Reponse();
                System.out.println("entrer le titre n" + (j + 1));
                sc.nextLine();
                repCrr.setTitre(sc.nextLine());
                System.out.println("est ce que la reponse est correct ? 0/1");
                repCrr.setCorrecte(sc.nextInt() == 0 ? false : true);
                this.questions[i].getReponses()[j] = new Reponse(repCrr.getTitre(), repCrr.isCorrecte());
            }
            sc.nextLine();
        }

    }

    public void resulta() {
        System.out.println("la resulta du questionnaire ");
        System.out.print(this.toString());
        System.out.println("votre score est : " + this.scoreTotale + "/20");
    }

    public void jouer() {
        Scanner sc = new Scanner(System.in);
        int choix;
        System.out.println("questionaire :" + titre);
        for (int i = 0; i < maxQSt; i++) {
            System.out.print("Q" + (i + 1) + ". " + this.questions[i].toString("en jouant"));
            System.out.println("choisis la bonne reponse :");
            choix = sc.nextInt();
            for (int j = 0; j < 3; j++) {
                if ((j + 1) == choix) {
                    this.scoreTotale += this.getQuestions()[i].getReponses()[j].isCorrecte() == true ? this.getQuestions()[i].getScore() : 0;
                }

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < maxQSt; i++) {
            res.append("Q" + (i + 1));
            res.append(". ");
            res.append(this.questions[i].toString());
        }

        return "> " + titre + '\n' + res.toString();
    }


    public void setMaxQSt(int maxQSt) {
        this.maxQSt = maxQSt;
    }
}
