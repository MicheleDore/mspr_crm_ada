package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.*;
import fr.epsi.poec24.mspr_crm_ada.service.CommandeService;
import fr.epsi.poec24.mspr_crm_ada.service.ContenuCommandeService;
import fr.epsi.poec24.mspr_crm_ada.service.EmployeService;
import fr.epsi.poec24.mspr_crm_ada.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/commandes")
public class CommandeController {
    private CommandeService commandeService;
    private ContenuCommandeService contenuCommandeService;

    private ProduitService produitService;

    private EmployeService employeService;




    @Autowired
    public CommandeController(CommandeService commandeService, ContenuCommandeService contenuCommandeService, ProduitService service3, EmployeService employeService) {
        this.commandeService = commandeService;
        this.contenuCommandeService = contenuCommandeService;
        this.produitService = service3;
        this.employeService = employeService;
    }


    @GetMapping("/{id}/detail")
    public String detailCommande(@PathVariable int id,Model model) {
        model.addAttribute("commande", commandeService.findById(id));
        model.addAttribute("valeur", commandeService.findCommandeValeurbyid(id));
        model.addAttribute("contenu", contenuCommandeService.findcontenuCommandebyid(id));
        System.out.println(model.addAttribute("contenu", contenuCommandeService.findcontenuCommandebyid(id)));

        return "view-commande-detail";
    }
    @GetMapping
    public String afficherListeCommande(Model model) {

        List<Object[]> mesCommandes= commandeService.findListeCommande();
        model.addAttribute("commandes", mesCommandes);
        System.out.println(model.addAttribute("commandes", mesCommandes));
        return "view-commandes-list";
    }

    @GetMapping("/{id}/creer")
    public String afficherFormulaireCreationCommande(@PathVariable int id,Model model) {
        Commande commande = new Commande();
        model.addAttribute("commande", commande);
        return "view-commande-form-creation";
    }
    @PostMapping("/{id}/creer")
    public String creerCommande(@PathVariable int id, // Récupère l'ID à partir de l'URL
                                @ModelAttribute Commande commande, // Lie les données du formulaire à un objet Commande
                                @RequestParam("quantite") Integer[] quantites, // Récupère les quantités des produits depuis le formulaire
                                @RequestParam("nomProduit") Integer[] produits) { // Récupère les identifiants des produits depuis le formulaire

        // Création d'une liste de ContenuCommande à partir des quantités et des produits
        List<ContenuCommande> contenuCommandes = new ArrayList<>();
        for (int i = 0; i < quantites.length; i++) {
            ContenuCommande contenuCommande = new ContenuCommande();

            // Récupération du Produit en fonction de son identifiant (produits[i])
            Produit produit = produitService.findById(produits[i]);

            // Initialisation des attributs du ContenuCommande
            contenuCommande.setCommande(commande);
            contenuCommande.setProduit(produit);
            contenuCommande.setQuantite(quantites[i]);
            contenuCommande.setCommande(commande); //  relation bidirectionnelle
            contenuCommandes.add(contenuCommande);
        }

        // Récupération des informations de l'utilisateur connecté
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nomUtilisateur = auth.getName(); // Récupère le nom d'utilisateur

        // Récupération de l'employé correspondant au nom d'utilisateur
        Employe employe = employeService.findByMailPro(nomUtilisateur);

        // Définition de l'employé pour cette commande
        commande.setEmploye(employe);

        // Définition de la liste des contenus de commande pour cette commande
        commande.setContenuCommandes(contenuCommandes);

        // Ajout de la date du jour à la commande
        commande.setDateCommande(new Date());

        // Création d'un objet Client avec l'ID spécifié et association avec la commande
        Client client = new Client();
        client.setIdPersonne(id);
        commande.setClient(client);

        // Enregistrement de la commande en utilisant le service commandeService
        commandeService.create(commande);

        // Redirection vers la page de détail du client avec l'ID spécifié
        return "redirect:/clients/{id}/detail";
    }

    @ModelAttribute("listeProduits")
    public List<Produit> getAllProducts() {
        return produitService.findAll();
    }


}
