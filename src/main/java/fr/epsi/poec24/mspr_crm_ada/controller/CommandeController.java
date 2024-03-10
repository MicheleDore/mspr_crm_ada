package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.*;
import fr.epsi.poec24.mspr_crm_ada.service.CommandeService;
import fr.epsi.poec24.mspr_crm_ada.service.ContenuCommandeService;
import fr.epsi.poec24.mspr_crm_ada.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/commandes")
public class CommandeController {
    private CommandeService service;
    private ContenuCommandeService service2;

    private ProduitService servive3;




    @Autowired
    public CommandeController(CommandeService service, ContenuCommandeService service2,ProduitService service3) {
        this.service = service;
        this.service2 = service2;
        this.servive3 = service3;
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

    @GetMapping("/{id}/creer")
    public String afficherFormulaireCreationCommande(@PathVariable int id,Model model) {
        List<Produit> produits = servive3.findAll();
        model.addAttribute("produits", produits);

        // Initialisez une commande avec une liste vide de contenuCommandes
        Commande commande = new Commande();
        commande.setContenuCommandes(new ArrayList<>());
        Employe employe = new Employe();
        employe.setIdPersonne(151);
        commande.setEmploye(employe);
        commande.setNumeroCommande(3000);
        // Ajouter la date du jour à la commande
        commande.setDateCommande(new Date());
        // Ajouter l'ID du client à la commande
        Client client = new Client();
        client.setIdPersonne(id);
        commande.setClient(client);
        // Ajoutez un élément vide à la liste pour le premier produit
        commande.getContenuCommandes().add(new ContenuCommande());
        // Afficher le contenu de la liste contenuCommandes
        for (ContenuCommande contenuCommande : commande.getContenuCommandes()) {
            System.out.println("Contenu de la commande : " + contenuCommande);
        }
        model.addAttribute("commande", commande);
        return "view-commande-form-creation";
    }
    @PostMapping("/{id}/creer")
    public String creerCommande(@ModelAttribute Commande commande) {


        service.create(commande);
        return "redirect:/{id}/detail";
    }
}
