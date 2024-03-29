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
    private final ProduitService service;

    @Autowired
    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping
    public String afficherListeProduit(Model model) {
        List<Object[]> mesProduits = service.findByEnCatalogue();
        model.addAttribute("produits", mesProduits);
        return "view-produits-list";
    }

    @GetMapping("/creer")
    public String creerProduits(Model model) {
        model.addAttribute("produits", new Produit());
        return "view-produit-form-creation";
    }
    @PostMapping("/creer")
    public String creerProduit(@ModelAttribute Produit produit) {
        service.create(produit);
        return "redirect:/produits";
    }

    @GetMapping("/{id}/edition")
    public String modifierproduits(@PathVariable int id, Model model) {
        model.addAttribute("produits", service.findById(id));
        return "view-produit-form-edition";
    }
    @PostMapping("/{id}/edition")
    public String modifierProduit(@PathVariable int id, @ModelAttribute Produit produit) {
        service.update(id, produit);
        return "redirect:/produits/{id}/detail";
    }

    @GetMapping("/{id}/edition-prix")
    public String modifierprix(@PathVariable int id, Model model) {
        model.addAttribute("produits", service.findById(id));
        service.outOfCatalogue(id);
        return "view-prix-form-edition";
    }
    @PostMapping("/edition-prix")
    public String modifierPrix(@ModelAttribute Produit produit) {
        service.create(produit);
        return "view-produit-detail";
    }

    @GetMapping("/{id}/suppression")
    public String supprimerProduit(@PathVariable int id) {
        //TODO il faut faire toutes les vérifications nécessaires ici
        service.outOfCatalogue(id);
        return "redirect:/produits";
    }
    @GetMapping("/{id}/detail")
    public String detailProduit(@PathVariable int id,Model model) {
        model.addAttribute("produit", service.findById(id));
        return "view-produit-detail";
    }
}
