package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDAO extends JpaRepository<Client, Integer> {


    @Query("SELECT clients, COALESCE(SUM(p.prix * cc.quantite), 0) AS MontantTotal " +
            "FROM Commande c " +
            "JOIN c.contenuCommandes cc " +
            "JOIN cc.produit p " +
            "JOIN c.client clients " +
            "GROUP BY clients.idPersonne, clients.dateEnregistrement " +
            "ORDER BY 2  DESC")
    public List<Object[]> findListeClientValeur();




}
