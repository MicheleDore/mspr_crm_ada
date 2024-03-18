package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.service.StatistiquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/statistiques/page")
public class StatistiquesController {
    private final StatistiquesService service;

    @Autowired
    public StatistiquesController(StatistiquesService service) {
        this.service = service;
    }

    @GetMapping
    public String afficherChiffresAffaire(@RequestParam("annee") String annee,Model model) {
        List<Object> mesCA = service.calculCA(annee);
        int total = service.totalAnnee(annee);
        List<Integer> annees= service.annees();
        model.addAttribute("total", total);
        model.addAttribute("CA", mesCA);
        model.addAttribute("annees", annees);
        return "view-statistiques";
    }
}
