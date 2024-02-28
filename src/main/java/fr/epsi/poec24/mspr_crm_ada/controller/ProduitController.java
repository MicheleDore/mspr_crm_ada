package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import fr.epsi.poec24.mspr_crm_ada.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produits")
public class ProduitController {
    private ProduitService service;

    @Autowired
    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping
    public String afficherListeProduit(Model model) {

        List<Produit> mesProduits = service.findAll();
        model.addAttribute("produits", mesProduits);
        return "view-produits-list";
    }
    @GetMapping("/creer")
    public String creerProduit(Model model) {
        model.addAttribute("produits", new Produit());
        return "view-produits-form-creation";
    }
    @PostMapping("/creer")
    public String creerProduit(@ModelAttribute Produit produit) {
        service.create(produit);
        return "redirect:/produits";
    }
    @GetMapping("/{id}/edition")
    public String modifierproduits(@PathVariable int id, Model model) {
        model.addAttribute("produits", service.findById(id));
        return "view-produits-form-edition";
    }
    @PostMapping("/{id}/edition")
    public String modifierProduit(@PathVariable int id, @ModelAttribute Produit produit) {
        produit.setIdProduit(id);
        service.update(produit);
        return "redirect:/produits";
    }

    @GetMapping("/{id}/suppression")
    public String supprimerProduit(@PathVariable int id) {
        //TODO il faut faire toutes les vérifications nécessaires ici
        service.deleteById(id);
        return "redirect:/produits";
    }
}
