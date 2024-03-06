package fr.epsi.poec24.mspr_crm_ada.service;

import fr.epsi.poec24.mspr_crm_ada.dal.ProduitDAO;
import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private ProduitDAO dao;

    @Autowired
    public ProduitService(ProduitDAO dao){ this.dao = dao;}

    public List<Produit> findByEnCatalogue() {
        return dao.findByEnCatalogue(true);
    }

    public Produit create(Produit produit) {
        return dao.save(produit);
    }

    public void outOfCatalogue(int id) {
        Optional<Produit> optionalProduit = dao.findById(id);
        Produit vieuxProduit = optionalProduit.get();
        vieuxProduit.setEnCatalogue(false);
        dao.save(vieuxProduit);
    }

    public Produit findById(int id) {
        return dao.findById(id).orElse(null);
    }

    public void update(Produit produit) {
        dao.save(produit);
    }

}
