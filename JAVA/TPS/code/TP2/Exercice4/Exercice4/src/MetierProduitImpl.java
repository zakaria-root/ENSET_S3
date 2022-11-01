import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetierProduit {
    private List<Produit> produits;

    public MetierProduitImpl(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public Produit add(Produit p) {
        if (produits.contains(p)) {
            System.out.println(" le prosuit existe deja");
            return null;
        } else {
            produits.add(p);
            return p;
        }

    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public List<Produit> findByNom(String motCle) {
        List<Produit> produits = new ArrayList<>();
        this.produits.forEach((Produit p) -> {
            if (p.getNom().contains(motCle)) {
                produits.add(p);
            }
        });

        return produits;
    }

    @Override
    public Produit findById(long id) {

        for (Produit p : produits) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        produits.removeIf(p -> p.getId() == id);
    }
}
