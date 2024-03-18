package fr.epsi.poec24.mspr_crm_ada.service;

import fr.epsi.poec24.mspr_crm_ada.dal.ClientDAO;
import fr.epsi.poec24.mspr_crm_ada.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDAO dao;

    @Autowired
    public ClientService(ClientDAO dao){this.dao = dao;}

    public List<Client> findAll() {return dao.findAll();}

    public Client create(Client client) {
        return dao.save(client);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public Client findById(int id) {return dao.findById(id).orElse(null);}

    public List<Object[]> findListeClientValeur() {
        return dao.findListeClientValeur();
    }

    public void update(Client client) {
        dao.save(client);
    }

}
