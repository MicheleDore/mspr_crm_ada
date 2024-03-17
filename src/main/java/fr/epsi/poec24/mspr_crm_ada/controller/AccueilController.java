package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.Employe;
import fr.epsi.poec24.mspr_crm_ada.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class AccueilController {

    private final EmployeService service4;

    @Autowired
    public AccueilController(EmployeService service4) {

        this.service4 = service4;
    }
    @GetMapping("/")
    public String afficherAccueil(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nomUtilisateur = auth.getName(); // Récupère le nom d'utilisateur
        Employe employe = service4.findByMailPro(nomUtilisateur);
        model.addAttribute("employe", employe);
        return "index";
    }
}
