package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProduitDAO extends JpaRepository<Produit, Integer> {
    List<Produit> findByEnCatalogue(boolean enCatalogue);
}
