package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.Commande;
import fr.epsi.poec24.mspr_crm_ada.domain.ContenuCommande;
import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import fr.epsi.poec24.mspr_crm_ada.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/commandes")
public class CommandeController {
    private CommandeService service;



    @Autowired
    public CommandeController(CommandeService service) {
        this.service = service;
    }

    @GetMapping
    public String afficherListeCommande(Model model) {
        List<Commande> mesCommandes = service.findAll();
        List<Integer> mesValeur= service.findCommande();
        model.addAttribute("commandes", mesCommandes);
        model.addAttribute("valeurs", mesValeur);

        System.out.println(mesValeur);
        return "view-commandes-list";
    }
}
