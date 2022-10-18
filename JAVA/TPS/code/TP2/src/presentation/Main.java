package presentation;

import metier.*;

public class Main {
    public static void main(String[] args) {
        //EXERCICE 1
//        Adherent adherent = new Adherent("adsa", "asda", "dasdas@gmail.com", 3234243,12);
//        Auteur auteur =new Auteur("dsad","dsad","dasdas@gmail.com",2133123,21);
//        Livre livre  =new Livre(1313,  auteur);
//        adherent.afficher();
//        livre.afficher();

//        EXERCICE 2
        Ingenieur ingenieur  =new Ingenieur("dsadd","dsada","dasd",20,20,"dsada");
        Manager manager  = new Manager("dsad","dsahaskd","dasd",222,22,"dasd");
        ingenieur.afficher();
        System.out.println();
        manager.afficher();

    }
}