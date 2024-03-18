package fr.epsi.poec24.mspr_crm_ada.domain;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "contenucommandes")
public class ContenuCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ContenuCommande")
    private int idContenuCommande;

    @ManyToOne
    @JoinColumn(name = "ID_Commande")
    private Commande commande;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Produit")
    private Produit produit;

    @Column(name = "Quantite")
    private int quantite =0;

    public ContenuCommande() {
    }

    public ContenuCommande(int idContenuCommande, Commande commande, Produit produit, int quantite) {
        this.idContenuCommande = idContenuCommande;
        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
    }

    public ContenuCommande(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    public int getIdContenuCommande() {
        return idContenuCommande;
    }

    public void setIdContenuCommande(int idContenuCommande) {
        this.idContenuCommande = idContenuCommande;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContenuCommande{");
        sb.append("idContenuCommande=").append(idContenuCommande);
        sb.append(", commande=").append(commande);
        sb.append(", produit=").append(produit);
        sb.append(", quantite=").append(quantite);
        sb.append('}');
        return sb.toString();
    }
}




