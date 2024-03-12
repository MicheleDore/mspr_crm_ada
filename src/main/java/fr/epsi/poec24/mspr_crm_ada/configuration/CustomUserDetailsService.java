package fr.epsi.poec24.mspr_crm_ada.configuration;

import fr.epsi.poec24.mspr_crm_ada.dal.ClientDAO;
import fr.epsi.poec24.mspr_crm_ada.dal.EmployeDAO;
import fr.epsi.poec24.mspr_crm_ada.domain.Employe;
import fr.epsi.poec24.mspr_crm_ada.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeService employeService;

    @Override
    public UserDetails loadUserByUsername(String mailPro) throws UsernameNotFoundException {
        Employe employe = employeService.findByMailPro(mailPro);
        return new User(employe.getMailPro(), employe.getPassword(),getGrantedAuthorities(employe.getRole()));
    }
    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }

}
