package fr.epsi.poec24.mspr_crm_ada.service;

import fr.epsi.poec24.mspr_crm_ada.dal.StatistiquesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatistiquesService {

    private StatistiquesDAO dao;

    @Autowired
    public StatistiquesService(StatistiquesDAO dao){ this.dao = dao;}

    public List<Integer> calculCA(String annee) {
        return dao.calculCA(annee);
    }

}