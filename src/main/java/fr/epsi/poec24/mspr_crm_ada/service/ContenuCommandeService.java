package fr.epsi.poec24.mspr_crm_ada.service;

import fr.epsi.poec24.mspr_crm_ada.dal.CommandeDAO;
import fr.epsi.poec24.mspr_crm_ada.dal.ContenuCommandeDAO;
import fr.epsi.poec24.mspr_crm_ada.domain.ContenuCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenuCommandeService {
    private ContenuCommandeDAO dao;


    @Autowired
    public ContenuCommandeService(ContenuCommandeDAO dao){ this.dao = dao;}

    public List<ContenuCommande> findAll(){ return dao.findAll();}
}
