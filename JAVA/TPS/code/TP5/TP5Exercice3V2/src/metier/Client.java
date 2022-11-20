package metier;

import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {
    private long id;
    private String nom;
    private String prenom;
    private String adresse;


    private String tel;
    private String email;

    public Client() {
    }

    public Client(long id, String nom, String prenom, String adresse, String tel, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }


    public String myToString() {
        return "\nClient : " + id +
                "\n----------" +
                "\n nom='" + nom + '\'' +
                "\nprenom='" + prenom + '\'' +
                "\nadresse='" + adresse + '\'' +
                "\ntel='" + tel + '\'' +
                "\nemail='" + email + '\'';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(nom, client.nom) && Objects.equals(prenom, client.prenom) && Objects.equals(adresse, client.adresse) && Objects.equals(tel, client.tel) && Objects.equals(email, client.email);
    }


}
