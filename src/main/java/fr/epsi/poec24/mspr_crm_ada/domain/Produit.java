package fr.epsi.poec24.mspr_crm_ada.domain;

import jakarta.persistence.*;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "produits")
public class Produit implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Produit")
    private int idProduit;

    @Column(name = "NomProduit")
    private String nomProduit;

    @Column(name = "Prix")
    private int prix;

    @Column(name = "Description")
    private String description;

    @Column(name = "DateCreationProduit")
    private LocalDateTime dateCreationProduit;


    //CONSTRUCTOR


    public Produit() {
       // this(0, "", 0, "", new Date()); // Vous pouvez ajuster les valeurs par défaut selon vos besoins
    }

    public Produit(int idProduit, String nomProduit, int prix) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
    }

    public Produit(int idProduit, String nomProduit, int prix, String description, LocalDateTime dateCreationProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.description = description;
        this.dateCreationProduit = dateCreationProduit;
    }

    public Produit(int idProduit, String nomProduit, int prix, LocalDateTime dateCreationProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.dateCreationProduit = dateCreationProduit;
    }

    public Produit(int idProduit, String nomProduit, LocalDateTime dateCreationProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.dateCreationProduit = dateCreationProduit;
    }
//GETTER & SETTER

    public int getIdProduit() {return idProduit;}
    public void setIdProduit(int idProduit) {this.idProduit = idProduit;}

    public String getNomProduit() {return nomProduit;}
    public void setNomProduit(String nomProduit) {this.nomProduit = nomProduit;}

    public int getPrix() {return prix;}
    public void setPrix(int prix) {this.prix = prix;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public LocalDateTime getDateCreationProduit() {return dateCreationProduit;}
    public void setDateCreationProduit(LocalDateTime dateCreationProduit) {this.dateCreationProduit = dateCreationProduit;}

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
        sb.append('}');
        return sb.toString();


    }
}