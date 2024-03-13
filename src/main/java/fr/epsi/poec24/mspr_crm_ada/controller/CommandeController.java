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
    private CommandeService service;
    private ContenuCommandeService service2;

    private ProduitService servive3;

    private EmployeService service4;




    @Autowired
    public CommandeController(CommandeService service, ContenuCommandeService service2,ProduitService service3, EmployeService service4) {
        this.service = service;
        this.service2 = service2;
        this.servive3 = service3;
        this.service4 = service4;
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
        Commande commande = new Commande();
        model.addAttribute("commande", commande);
        return "view-commande-form-creation";
    }
    @PostMapping("/{id}/creer")
    public String creerCommande(@PathVariable int id,@ModelAttribute Commande commande, @RequestParam ("quantite") Integer[] quantites,@RequestParam ("nomProduit") Integer[] produits) {


        commande.getIdCommande();
        // Créez la liste de contenuCommandes à partir des quantités et des produits
        List<ContenuCommande> contenuCommandes = new ArrayList<>();

        for (int i = 0; i < quantites.length; i++) {
            ContenuCommande contenuCommande = new ContenuCommande();

            // Vous devez définir la logique pour récupérer le Produit en fonction du nom (produits[i])
            Produit produit = servive3.findById(produits[i]); // À adapter à votre logique
            contenuCommande.setCommande(commande);
            contenuCommande.setProduit(produit);
            contenuCommande.setQuantite(quantites[i]);
            // Assurez-vous de définir la relation bidirectionnelle
            contenuCommande.setCommande(commande);
            contenuCommandes.add(contenuCommande);
        }
        // Récupérer les informations de l'utilisateur connecté
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nomUtilisateur = auth.getName(); // Récupère le nom d'utilisateur
        // Utilisez le nom d'utilisateur pour obtenir l'employé correspondant
        Employe employe = service4.findByMailPro(nomUtilisateur);
        commande.setEmploye(employe);
        commande.setContenuCommandes(contenuCommandes);


        commande.setEmploye(employe);
        // Ajouter la date du jour à la commande
        commande.setDateCommande(new Date());
        // Ajouter l'ID du client à la commande
        Client client = new Client();
        client.setIdPersonne(id);
        commande.setClient(client);
        service.create(commande);
        return "redirect:/clients/{id}/detail";
    }
    @ModelAttribute("listeProduits")
    public List<Produit> getAllProducts() {
        return servive3.findAll();
    }
    // Méthode pour générer le numéro de commande unique


}
