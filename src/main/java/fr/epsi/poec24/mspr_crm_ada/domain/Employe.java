package fr.epsi.poec24.mspr_crm_ada.domain;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employes")
@PrimaryKeyJoinColumn(name = "ID_Employe")
public class Employe extends Personne implements Serializable{


    @Column(name="Matricule")
    private int matricule;

    @Column (name="DateEmbauche")
    private Date dateEmbauche;

    @Column (name="MailPro")
    private String mailPro;


    @Column (name="password")
    private String password;

    @Column (name="role")
    private String role;

    //CONSTRUCTOR

    public Employe() {
    }

    public Employe(String mailPro, String password, String role) {
        this.mailPro = mailPro;
        this.password = password;
        this.role = role;
    }

    public Employe(int matricule, Date dateEmbauche, String mailPro, String password, String role) {
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.mailPro = mailPro;
        this.password = password;
        this.role = role;
    }

    public Employe(int idPersonne, String nom, String prenom, String cp, String ville, String rue, String tel, String mail, int matricule, Date dateEmbauche, String mailPro, String password, String role) {
        super(idPersonne, nom, prenom, cp, ville, rue, tel, mail);
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.mailPro = mailPro;
        this.password = password;
        this.role = role;
    }

    public Employe(int idPersonne, int matricule, Date dateEmbauche, String mailPro, String password, String role) {
        super(idPersonne);
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.mailPro = mailPro;
        this.password = password;
        this.role = role;
    }

    public Employe(int idPersonne, String nom, String prenom, String cp, String ville, String rue, String tel, String mail, int matricule, Date dateEmbauche) {
        super(idPersonne, nom, prenom, cp, ville, rue, tel, mail);
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.mailPro = mail;
    }

    public Employe(int idPersonne, String nom, String prenom, String cp, String ville, String rue, String tel, String mail) {
        super(idPersonne, nom, prenom, cp, ville, rue, tel, mail);
    }
//GETTER & SETTER

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMatricule() {return matricule;}
    public void setMatricule(int matricule) {this.matricule = matricule;}

    public Date getDateEmbauche() {return dateEmbauche;}
    public void setDateEmbauche(Date dateEmbauche) {this.dateEmbauche = dateEmbauche;}

    public String getMailPro() {return mailPro;}
    public void setMailPro(String mailPro) {this.mailPro = mailPro;}

    @Override
    public String toString() {
        return "employes{" +
                "matricule=" + matricule +
                ", dateEmbauche=" + dateEmbauche +
                ", mailPro='" + mailPro + '\'' +
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
