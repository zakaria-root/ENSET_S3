package metier;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits ;
    private String fileName;



    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MetierProduitImpl(List<Produit> produits, String fileName) throws IOException, ClassNotFoundException {
        this.produits = produits;
        this.fileName = fileName;
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileInputStream fos = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fos);
            this.produits = (List<Produit>) ois.readObject();
            ois.close();

        }
    }

    @Override
    public Produit add(Produit c)  {
        if (c != null) {
            if (produits.contains(c)) {
                System.out.println("Produit already exists");
            } else {
                produits.add(c);
//                saveAllProduits();
                System.out.println("Produit added successfully");
            }
            return c;
        }
        return null;
    }

    @Override
    public void saveAll() throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(produits);
        oos.close();


    }

    @Override
    public void delete(long id)  {
        produits.removeIf(client -> client.getId() == id);
//        saveAllProduits();
    }

    @Override
    public List<Produit> getAll()  {

        if (produits.isEmpty()) {
            System.out.println("No produits found");
        } else {

            return produits;

        }
        return null;
    }

    @Override
    public Produit findById(long id) {
        for (Produit client : produits) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }



}
