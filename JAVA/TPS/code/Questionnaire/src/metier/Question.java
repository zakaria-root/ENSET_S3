package metier;

public class Question {
    private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Reponse[] getReponses() {
        return reponses;
    }

    public void setReponses(Reponse[] reponses) {
        this.reponses = reponses;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private String desc;
    private Reponse reponses[];
    private int score;

    public Question() {
        this.titre = "";
        this.desc = "";
        this.score = 0;
        this.reponses = new Reponse[3];

    }

    public Question(String titre, String desc, int score) {
        this.titre = titre;
        this.desc = desc;
        this.score = score;
        this.reponses = new Reponse[3];

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < 3; i++) {
            res.append(" " + (i + 1));
            res.append('-');
            res.append(this.reponses[i].toString());
            res.append('\n');
        }

        return titre + " ( " + this.score + " )\n" +
                desc + '\n' +
                res.toString() ;
    }


    public String toString(String etat) {

        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < 3; i++) {
            res.append(" " + (i + 1));
            res.append('-');
            if (etat.equals("en jouant")) {
                res.append(this.reponses[i].toString("en jouant"));
            } else {
                res.append(this.reponses[i].toString());
            }
            res.append('\n');
        }
        return titre + " ( " + this.score + " )\n" +
                desc + '\n' +
                res.toString() ;
    }
}
