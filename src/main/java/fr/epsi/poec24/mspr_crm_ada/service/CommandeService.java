package fr.epsi.poec24.mspr_crm_ada.service;


import fr.epsi.poec24.mspr_crm_ada.dal.CommandeDAO;
import fr.epsi.poec24.mspr_crm_ada.dal.ProduitDAO;
import fr.epsi.poec24.mspr_crm_ada.domain.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    private CommandeDAO dao;
    @Autowired
    public CommandeService(CommandeDAO dao){ this.dao = dao;}

    public List<Commande> findAll() {
        return dao.findAll();
    }
    public Commande findById(int id) {
        return dao.findById(id).orElse(null);
    }

    public int findCommandeValeurbyid(int id){ return dao.findContenuCommande(id);}

    public List<Object[]> findListeCommande() {
        return dao.findListeCommandeValeur();
    }

    public List<Object[]> findListeCommancebyid(int id){return  dao.findCommandesAndMontantTotalByClientId(id);}

}
