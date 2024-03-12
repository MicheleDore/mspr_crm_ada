package fr.epsi.poec24.mspr_crm_ada.service;

import fr.epsi.poec24.mspr_crm_ada.dal.ClientDAO;
import fr.epsi.poec24.mspr_crm_ada.dal.CommandeDAO;
import fr.epsi.poec24.mspr_crm_ada.dal.EmployeDAO;
import fr.epsi.poec24.mspr_crm_ada.domain.Client;
import fr.epsi.poec24.mspr_crm_ada.domain.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeService {

    private EmployeDAO dao;

    @Autowired
    public EmployeService(EmployeDAO dao){ this.dao = dao;}

    public Employe findByMailPro(String mailPro) {
        return dao.findByMailPro( mailPro);
    }
}
