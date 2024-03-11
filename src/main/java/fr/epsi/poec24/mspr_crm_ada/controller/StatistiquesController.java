package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.service.ProduitService;
import fr.epsi.poec24.mspr_crm_ada.service.StatistiquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/statistiques")
public class StatistiquesController {
    private StatistiquesService service;

    @Autowired
    public StatistiquesController(StatistiquesService service) {
        this.service = service;
    }

    public String afficherPage() {

        return "view-statistiques";
    }
}
