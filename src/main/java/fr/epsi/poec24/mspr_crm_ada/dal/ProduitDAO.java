package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProduitDAO extends JpaRepository<Produit, Integer> {

    @Query("SELECT p, COALESCE(SUM(cc.quantite),0) as quantiteTotale " +
            "FROM Produit p " +
            "LEFT JOIN p.contenuCommande cc ON p.idProduit = cc.produit.idProduit " +
            "WHERE p.enCatalogue=true " +
            "GROUP BY p.idProduit " +
            "ORDER BY 2 DESC")
    public List<Object[]> findByEnCatalogue();
}
