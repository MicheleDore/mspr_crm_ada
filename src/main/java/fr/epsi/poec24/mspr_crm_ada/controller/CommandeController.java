package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.Commande;
import fr.epsi.poec24.mspr_crm_ada.domain.ContenuCommande;
import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import fr.epsi.poec24.mspr_crm_ada.service.CommandeService;
import fr.epsi.poec24.mspr_crm_ada.service.ContenuCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/commandes")
public class CommandeController {
    private CommandeService service;
    private ContenuCommandeService service2;




    @Autowired
    public CommandeController(CommandeService service, ContenuCommandeService service2) {
        this.service = service;
        this.service2 = service2;
    }


    @GetMapping("/{id}/detail")
    public String detailCommande(@PathVariable int id,Model model) {
        model.addAttribute("commande", service.findById(id));
        model.addAttribute("valeur", service.findCommandeValeurbyid(id));
        model.addAttribute("contenu", service2.findcontenuCommandebyid(id));
        System.out.println(model.addAttribute("contenu", service2.findcontenuCommandebyid(id)));

        return "view-commande-detail";
    }
    @GetMapping
    public String afficherListeCommande(Model model) {

        List<Object[]> mesCommandes= service.findListeCommande();
        model.addAttribute("commandes", mesCommandes);
        System.out.println(model.addAttribute("commandes", mesCommandes));
        return "view-commandes-list";
    }
}
