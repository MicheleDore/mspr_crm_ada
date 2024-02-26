package fr.epsi.poec24.mspr_crm_ada.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
public class produits implements Serializable{

    private int idProduit;
    private String nomProduit;
    private int prix;
    private String description;
    private Date dateCreationProduit;


    //CONSTRUCTOR
    public produits(int idProduit, String nomProduit, int prix, String description, Date dateCreationProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.description = description;
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

    public Date getDateCreationProduit() {return dateCreationProduit;}
    public void setDateCreationProduit(Date dateCreationProduit) {this.dateCreationProduit = dateCreationProduit;}
}
