package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatistiquesDAO extends JpaRepository<Commande, Integer> {
    @Query(value ="SELECT sum(cc.quantite*p.prix) as chiffreAffaire from commandes c JOIN contenucommandes cc ON cc.id_commande=c.id_commande JOIN produits p ON p.id_produit=cc.id_produit WHERE year(DateCommande)=:annee Group by month(DateCommande) order by month(DateCommande)", nativeQuery = true)
    public List<Integer> calculCA(String annee);
}
