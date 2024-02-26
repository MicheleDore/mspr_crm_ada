package fr.epsi.poec24.mspr_crm_ada.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
public class commandes implements Serializable{

    private int idCommande;
    private Date dateCommande;
    private int numeroCommande;

    //CONSTRUCTOR
    public commandes(int idCommande, Date dateCommande, int numeroCommande) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.numeroCommande = numeroCommande;
    }

    //GETTER & SETTER
    public int getIdCommande() {return idCommande;}
    public void setIdCommande(int idCommande) {this.idCommande = idCommande;}

    public Date getDateCommande() {return dateCommande;}
    public void setDateCommande(Date dateCommande) {this.dateCommande = dateCommande;}

    public int getNumeroCommande() {return numeroCommande;}
    public void setNumeroCommande(int numeroCommande) {this.numeroCommande = numeroCommande;}
}
