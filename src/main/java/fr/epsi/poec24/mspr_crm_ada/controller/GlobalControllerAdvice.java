package fr.epsi.poec24.mspr_crm_ada.controller;

import fr.epsi.poec24.mspr_crm_ada.domain.Employe;
import fr.epsi.poec24.mspr_crm_ada.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private EmployeService employeService;

    @ModelAttribute("employe")
    public Employe getEmploye() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String employe = auth.getName(); // Récupère le nom d'utilisateur
        return employeService.findByMailPro(employe);
    }
}
