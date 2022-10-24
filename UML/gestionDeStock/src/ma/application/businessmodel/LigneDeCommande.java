package ma.application.businessmodel;

import java.util.ArrayList;
import java.util.List;

public class LigneDeCommande {
    @Override
    public String toString() {
        return "LigneDeCommande{" +
                "id=" + id +
                ", qte=" + qte +
                ", souTotal=" + souTotal +
                ", factures=" + factures +
                ", produit=" + produit +
                '}';
    }
    private Long id;
    private Integer qte;
    private Double souTotal;
    private List<Facture> factures;
    private Produit produit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public void setFacture(List<Facture> facture) {
        this.factures = facture;
    }

    public List<Facture> getFacture() {
        return factures;
    }

    public Double getSouTotal() {
        return souTotal;
    }

    public void setSouTotal(Double souTotal) {
        this.souTotal = souTotal;
    }

//    public Facture getFacture() {
//        return facture;
//    }
//
//    public void setFacture(Facture facture) {
//        this.facture = facture;
//    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public LigneDeCommande(Long id, Integer qte, Double souTotal, Facture facture, Produit produit) {
        this.id = id;
        this.qte = qte;
        this.souTotal = souTotal;
        this.factures =new ArrayList<>();
        this.factures.add(facture);
        this.produit = produit;
    }


}
