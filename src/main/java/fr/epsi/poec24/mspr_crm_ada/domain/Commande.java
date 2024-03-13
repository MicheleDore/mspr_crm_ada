package fr.epsi.poec24.mspr_crm_ada.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "commandes")
@PrimaryKeyJoinColumn(name = "ID_Commande")
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Commande")
    private int idCommande;

    @Column(name = "DateCommande")
    private Date dateCommande = Date.from(Instant.now());




    @ManyToOne
    @JoinColumn(name = "ID_Client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "ID_Employe")
    private Employe employe;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ContenuCommande> contenuCommandes;


    //CONSTRUCTOR




    public Commande() {
    }

    public Commande(int idCommande, Date dateCommande, Client client, Employe employe, List<ContenuCommande> contenuCommandes) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.client = client;
        this.employe = employe;
        this.contenuCommandes = contenuCommandes;
    }



    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }





    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<ContenuCommande> getContenuCommandes() {
        return contenuCommandes;
    }

    public void setContenuCommandes(List<ContenuCommande> contenuCommandes) {
        this.contenuCommandes = contenuCommandes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Commande{");
        sb.append("idCommande=").append(idCommande);
        sb.append(", dateCommande=").append(dateCommande);
        sb.append(", client=").append(client);
        sb.append(", employe=").append(employe);
        sb.append('}');
        return sb.toString();
    }
}
