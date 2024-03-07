package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProduitDAO extends JpaRepository<Produit, Integer> {

    @Query("SELECT p, SUM(cc.quantite) as quantiteTotale " +
            "FROM Produit p " +
            "JOIN p.contenuCommande cc " +
            "WHERE p.enCatalogue=true " +
            "GROUP BY p.idProduit " +
            "ORDER BY quantiteTotale DESC")
    public List<Object[]> findByEnCatalogue();
}
