package fr.epsi.poec24.mspr_crm_ada.service;

import fr.epsi.poec24.mspr_crm_ada.dal.ClientDAO;
import fr.epsi.poec24.mspr_crm_ada.domain.Client;
import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientDAO dao;

    @Autowired
    public ClientService(ClientDAO dao){this.dao = dao;}

    public List<Client> findAll() {
        return dao.findAll();
    }

}
