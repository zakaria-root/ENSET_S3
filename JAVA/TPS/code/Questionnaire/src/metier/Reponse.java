package metier;

public class Reponse {
    private String titre;
    private boolean correcte;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isCorrecte() {
        return correcte;
    }

    public void setCorrecte(boolean correcte) {
        this.correcte = correcte;
    }

    public Reponse() {
        this.titre = "";
        this.correcte = false;
    }

    public Reponse(String titre, boolean correcte) {
        this.titre = titre;
        this.correcte = correcte;
    }

    @Override
    public String toString() {
          return correcte ? titre + " (vrais))\n" : titre + " (faux))\n";
    }

    public String toString(String etat) {
        if (!etat.equals("en jouant")) {
            return correcte ? titre + " (vrais))\n" : titre + " (faux))\n";
        } else {
            return titre + "\n";
        }
    }
}
