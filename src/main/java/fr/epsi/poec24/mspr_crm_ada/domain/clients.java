package fr.epsi.poec24.mspr_crm_ada.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class clients extends personnes implements Serializable{


    private Date dateEnregistrement;

    public clients(int idPersonne, String nom, String prenom, String cp, String ville, String rue, String tel, String mail, Date dateEnregistrement) {
        super(idPersonne, nom, prenom, cp, ville, rue, tel, mail);
        this.dateEnregistrement = dateEnregistrement;
    }

    //GETTER & SETTER

    public Date getDateEnregistrement() {return dateEnregistrement;}
    public void setDateEnregistrement(Date dateEnregistrement) {this.dateEnregistrement = dateEnregistrement;}

    @Override
    public String toString() {
        return "clients{" +
                "dateEnregistrement=" + dateEnregistrement +
                ", idPersonne=" + idPersonne +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cp='" + cp + '\'' +
                ", ville='" + ville + '\'' +
                ", rue='" + rue + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
