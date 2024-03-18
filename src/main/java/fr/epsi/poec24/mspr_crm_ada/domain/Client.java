package fr.epsi.poec24.mspr_crm_ada.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "clients")
@PrimaryKeyJoinColumn(name = "ID_Client")
public class Client extends Personne implements Serializable{

    @Column (name="Date_Enregistrement")
    private final Date dateEnregistrement =  Date.from(Instant.now());



    //CONSTRUCTOR
    public Client() {

    }

    public Client(int idPersonne, String nom, String prenom, String cp, String ville, String rue, String tel, String mail) {
        super(idPersonne, nom, prenom, cp, ville, rue, tel, mail);
    }

    @Override
    public String toString() {
        return "Client{" + "dateEnregistrement=" + dateEnregistrement +
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
