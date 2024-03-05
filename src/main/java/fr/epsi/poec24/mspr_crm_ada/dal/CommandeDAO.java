package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface CommandeDAO extends JpaRepository<Commande, Integer> {
    @Query(value = "SELECT  SUM(p.Prix * cc.Quantite) AS montantTotal FROM commandes c JOIN contenucommandes cc ON cc.ID_Commande = c.ID_Commande JOIN produits p ON p.ID_Produit = cc.ID_Produit GROUP BY c.ID_Commande",nativeQuery = true)
    public List<Integer> findCommandeValeur();

    }

