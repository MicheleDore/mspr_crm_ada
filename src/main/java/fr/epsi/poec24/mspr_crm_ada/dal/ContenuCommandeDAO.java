package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.ContenuCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContenuCommandeDAO extends JpaRepository<ContenuCommande, Integer> {

    @Query(value = "select * from contenucommandes cc WHERE cc.ID_commande = :id",nativeQuery = true)
     List<ContenuCommande> findContenuCommande(@Param("id")int id);
}
