package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.ContenuCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenuCommandeDAO extends JpaRepository<ContenuCommande, Integer> {
}
