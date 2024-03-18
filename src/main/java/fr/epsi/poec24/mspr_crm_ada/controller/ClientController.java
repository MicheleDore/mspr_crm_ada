package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.Client;
import fr.epsi.poec24.mspr_crm_ada.service.ClientService;
import fr.epsi.poec24.mspr_crm_ada.service.CommandeService;
import fr.epsi.poec24.mspr_crm_ada.service.ContenuCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private ClientService service;
    private CommandeService service2;


    @Autowired
    public ClientController(ClientService service,CommandeService service2){this.service = service;this.service2 = service2;}

    @GetMapping
    public String afficherListeClient(Model model){

        List<Object[]> mesClients = service.findListeClientValeur();
        model.addAttribute("clients", mesClients);
        System.out.println(mesClients);
        return "view-clients-list";
    }

    @GetMapping("/creer")
    public String creerClient(Model model) {
        model.addAttribute("clients", new Client());
        return "view-clients-form-creation";
    }

    @PostMapping("/creer")
    public String creerClient(@ModelAttribute Client client) {
        service.create(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edition")
    public String modifierClient(@PathVariable int id, Model model) {
        model.addAttribute("clients", service.findById(id));
        System.out.println(model);
        return "view-clients-form-edition";
    }
    @PostMapping("/{id}/edition")
    public String modifierClient(@PathVariable int id, @ModelAttribute Client client) {
        System.out.println(client);
        client.setIdPersonne(id);
        service.update(client);
        return "redirect:/clients/{id}/detail";
    }

    @GetMapping("/{id}/suppression")
    public String supprimerClient(@PathVariable int id) {
        //TODO il faut faire toutes les vérifications nécessaires ici
        service.deleteById(id);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/detail")
    public String detailClient(@PathVariable int id, Model model) {
        model.addAttribute("clients", service.findById(id));
        model.addAttribute("commandes", service2.findListeCommancebyid(id));
        System.out.println(model);
        return "view-clients-detail";
    }

}
