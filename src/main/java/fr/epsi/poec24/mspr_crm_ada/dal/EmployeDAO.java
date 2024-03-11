package fr.epsi.poec24.mspr_crm_ada.dal;

import fr.epsi.poec24.mspr_crm_ada.domain.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeDAO extends JpaRepository<Employe, Integer> {
//    public Employe findByMail(String mailPro);

    public Employe findByMailPro(String mailPro);


}
