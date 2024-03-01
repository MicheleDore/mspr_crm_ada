package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.Client;
import fr.epsi.poec24.mspr_crm_ada.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
