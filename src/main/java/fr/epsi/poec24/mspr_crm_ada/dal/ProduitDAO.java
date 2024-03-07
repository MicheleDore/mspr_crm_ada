package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;


public interface ProduitDAO extends JpaRepository<Produit, Integer> {
//    public List<Produit> findByEnCatalogue(boolean enCatalogue);

    @Query(value="SELECT sum(cc.quantite) as quantiteTotale from produits p JOIN contenucommandes cc Group by cc.id_produit Order by quantiteTotale DESC", nativeQuery = true)
    public List<Objects[]> findByEnCatalogue(boolean enCatalogue);
}
