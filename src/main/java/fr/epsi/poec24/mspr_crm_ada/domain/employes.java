package fr.epsi.poec24.mspr_crm_ada.domain;



import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class employes extends personnes implements Serializable{

    private int matricule;
    private Date dateEmbauche;
    private String mailPro;

    //CONSTRUCTOR
    public employes(int idPersonne, String nom, String prenom, String cp, String ville, String rue, String tel, String mail, int matricule, Date dateEmbauche) {
        super(idPersonne, nom, prenom, cp, ville, rue, tel, mail);
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.mailPro = mail;
    }


    //GETTER & SETTER

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
