package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.Client;
import fr.epsi.poec24.mspr_crm_ada.domain.Produit;
import fr.epsi.poec24.mspr_crm_ada.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private ClientService service;

    @Autowired
    public ClientController(ClientService service){this.service = service;}

    @GetMapping
    public String afficherListeClient(Model model){
        List<Client> mesClients = service.findAll();
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
        return "view-client-form-edition";
    }
    @PostMapping("/{id}/edition")
    public String modifierClient(@PathVariable int id, @ModelAttribute Client client) {
        client.setIdPersonne(id);
        service.update(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/suppression")
    public String supprimerClient(@PathVariable int id) {
        //TODO il faut faire toutes les vérifications nécessaires ici
        service.deleteById(id);
        return "redirect:/clients";
    }

}
