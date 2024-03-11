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
    private Date dateEnregistrement =  Date.from(Instant.now());



    //CONSTRUCTOR
    public Client() {

    }

    public Client(int idPersonne, String nom, String prenom, String cp, String ville, String rue, String tel, String mail) {
        super(idPersonne, nom, prenom, cp, ville, rue, tel, mail);
    }



    //GETTER & SETTER

    public Date getDateEnregistrement() {return dateEnregistrement;}
    public void setDateEnregistrement(Date dateEnregistrement) {this.dateEnregistrement = dateEnregistrement;}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("dateEnregistrement=").append(dateEnregistrement);
        sb.append(", idPersonne=").append(idPersonne);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", cp='").append(cp).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append(", mail='").append(mail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
