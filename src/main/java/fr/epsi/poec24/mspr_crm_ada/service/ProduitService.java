package fr.epsi.poec24.mspr_crm_ada.service;

import fr.epsi.poec24.mspr_crm_ada.dal.ProduitDAO;
import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private ProduitDAO dao;

    @Autowired
    public ProduitService(ProduitDAO dao){ this.dao = dao;}

    public List<Produit> findAll() {
        return dao.findAll();
    }

    public Produit create(Produit produit) {
        return dao.save(produit);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public Produit findById(int id) {
        return dao.findById(id).orElse(null);
    }

    public void update(Produit produit) {
        dao.save(produit);
    }

}
