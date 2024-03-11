package fr.epsi.poec24.mspr_crm_ada.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "personnes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Personne")
    protected int idPersonne;

    @Column(name = "Nom")
    protected String nom;

    @Column(name = "Prenom")
    protected String prenom;

    @Column(name = "CP")
    protected String cp;

    @Column(name = "Ville")
    protected String ville;

    @Column(name = "Rue")
    protected String rue;

    @Column(name = "TelephonePerso")
    protected String tel;

    @Column(name = "MailPerso")
    protected String mail;

    public Personne() {
    }

    public Personne(int idPersonne, String nom, String prenom, String cp, String ville, String rue, String tel, String mail) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.cp = cp;
        this.ville = ville;
        this.rue = rue;
        this.tel = tel;
        this.mail = mail;
    }

    public Personne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    //GETTER & SETTER
    public int getIdPersonne() {return idPersonne;}
    public void setIdPersonne(int idPersonne) {this.idPersonne = idPersonne;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}

    public String getCp() {return cp;}
    public void setCp(String cp) {this.cp = cp;}

    public String getVille() {return ville;}
    public void setVille(String ville) {this.ville = ville;}

    public String getRue() {return rue;}
    public void setRue(String rue) {this.rue = rue;}

    public String getTel() {return tel;}
    public void setTel(String tel) {this.tel = tel;}

    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}

    @Override
    public String toString() {
        return "personnes{" +
                "idPersonne=" + idPersonne +
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
