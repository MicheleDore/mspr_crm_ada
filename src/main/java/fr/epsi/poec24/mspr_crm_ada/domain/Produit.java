package fr.epsi.poec24.mspr_crm_ada.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "produits")
public class Produit implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Produit")
    private int idProduit;

    @Column(name="NomProduit")
    private String nomProduit;

    @Column(name="Prix")
    private int prix;

    @Column(name="Description")
    private String description;

    @Column(name="DateCreationProduit")
    private Date dateCreationProduit =  Date.from(Instant.now());

    @OneToMany(mappedBy = "produit", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<ContenuCommande> contenuCommandes;


    @Column(name="EnCatalogue")
    private boolean enCatalogue= true;

//CONSTRUCTOR
    @Column(name="DateSuppressionProduit")
    private Date dateSuppressionProduit= null;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ContenuCommande> contenuCommande;
    //CONSTRUCTOR


    public Produit() {
       // this(0, "", 0, "", new Date()); // Vous pouvez ajuster les valeurs par défaut selon vos besoins
    }

    public Produit(int idProduit, String nomProduit, int prix, String description, Date dateCreationProduit, boolean enCatalogue, Date dateSuppressionProduit, List<ContenuCommande> contenuCommande) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.description = description;
        this.dateCreationProduit = dateCreationProduit;
        this.enCatalogue=enCatalogue;
        this.dateSuppressionProduit=dateSuppressionProduit;
        this.contenuCommande=contenuCommande;
    }

//GETTER & SETTER

    public List<ContenuCommande> getContenuCommandes() {
        return contenuCommandes;
    }

    public void setContenuCommandes(List<ContenuCommande> contenuCommandes) {
        this.contenuCommandes = contenuCommandes;
    }

    public int getIdProduit() {return idProduit;}
    public void setIdProduit(int idProduit) {this.idProduit = idProduit;}

    public String getNomProduit() {return nomProduit;}
    public void setNomProduit(String nomProduit) {this.nomProduit = nomProduit;}

    public int getPrix() {return prix;}
    public void setPrix(int prix) {this.prix = prix;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Date getDateCreationProduit() {return dateCreationProduit;}
    public void setDateCreationProduit(Date dateCreationProduit) {this.dateCreationProduit = dateCreationProduit;}

    public boolean isEnCatalogue() {
        return enCatalogue;
    }

    public void setEnCatalogue(boolean enCatalogue) {
        this.enCatalogue = enCatalogue;
    }

    public Date getDateSuppressionProduit() {
        return dateSuppressionProduit;
    }

    public void setDateSuppressionProduit(Date dateSuppressionProduit) {
        this.dateSuppressionProduit = dateSuppressionProduit;
    }

    public List<ContenuCommande> getContenuCommande() {
        return contenuCommande;
    }

    public void setContenuCommande(List<ContenuCommande> contenuCommande) {
        this.contenuCommande = contenuCommande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return idProduit == produit.idProduit && prix == produit.prix && Objects.equals(nomProduit, produit.nomProduit) && Objects.equals(description, produit.description) && Objects.equals(dateCreationProduit, produit.dateCreationProduit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduit, nomProduit, prix, description, dateCreationProduit);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append("idProduit=").append(idProduit);
        sb.append(", nomProduit='").append(nomProduit).append('\'');
        sb.append(", prix=").append(prix);
        sb.append(", description='").append(description).append('\'');
        sb.append(", dateCreationProduit=").append(dateCreationProduit);
        sb.append(", enCatalogue=").append(enCatalogue);
        sb.append(", dateSuppressionProduit=").append(dateSuppressionProduit);
        sb.append('}');
        return sb.toString();


    }
}