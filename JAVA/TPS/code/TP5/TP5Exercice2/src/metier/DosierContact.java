package metier;

import java.io.*;
import java.util.List;
import java.util.Objects;


public class DosierContact {

    private List<String> noms;
    private List<String> numeros;


    //    Ajouter les méthodes qui vont permettre d’ajouter un
    public boolean ajouterContact(String nom, String numero) throws IOException {

        File file = new File("contacts\\", nom + ".txt");
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(numero);
                bw.close();
                noms.add(nom);
                numeros.add(numero);
                return true;
            } else {
                System.out.println("File already exists.");
                return false;
            }
        } else {
            System.out.println("File already exists.");
        }

        return false;
    }

    //    contact, de supprimer un contact,
    public boolean supprimerContact(String nom) {
        File file = new File("contacts\\", nom + ".txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Deleted the file: " + file.getName());
                int index = noms.indexOf(nom);
                if (index != -1) {
                    if (numeros.remove(index) != null && noms.remove(index) != null)
                        return true;
                }
                return true;
            } else {
                System.out.println("Failed to delete the file.");
                return false;
            }
        } else {
            System.out.println("File does not exist.");

        }
        return false;
    }

    //    de rechercher un contact par nom, et de changer le
    public boolean rechercherContact(String nom) throws IOException {


        if (noms.contains(nom)) {
            int index = noms.indexOf(nom);
            System.out.println("Number : " + numeros.get(index));
            return true;
        }

        return false;
    }


    public DosierContact(List<String> noms, List<String> numeros) throws IOException {
        File dir = new File("contacts");
        this.noms = noms;
        this.numeros = numeros;
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("Le dossier a été créé");
        } else {
            LireDonnees();
        }
    }

    private void LireDonnees() throws IOException {
        File dir = new File("contacts");
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line = br.readLine();
                    noms.add(file.getName());
                    numeros.add(line);
                    br.close();
                }
            }
        }else{
            System.out.println("Le dossier n'existe pas");
        }
    }

    public void afficherTousLesContacts() {
        for (int i = 0; i < noms.size(); i++) {
            System.out.println("Nom : " + noms.get(i) + " | Numero : " + numeros.get(i));
        }
    }

    public boolean modifierNumeroContact(String nom, String numero) throws IOException {
        File dir = new File("contacts");
        for (File file : dir.listFiles()) {
            if (file.getName().equals(nom + ".txt")) {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write( numero);
                bw.close();
                int index = noms.indexOf(nom);
                if (index != -1) {
                    numeros.set(index, String.valueOf(numero));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DosierContact that = (DosierContact) o;
        return Objects.equals(noms, that.noms) && Objects.equals(numeros, that.numeros);
    }

}
