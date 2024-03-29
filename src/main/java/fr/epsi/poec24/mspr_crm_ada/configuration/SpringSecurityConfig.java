package fr.epsi.poec24.mspr_crm_ada.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().authorizeHttpRequests(auth ->{
            auth.requestMatchers("/statistiques/page").hasRole("DIR-COM");
            auth.requestMatchers("/commandes").permitAll();
            auth.requestMatchers("/commandes/{id}/detail").permitAll();
            auth.requestMatchers("/commandes/{id}/creer").hasAnyRole("COMMERCIAL","DIR-COM");
            auth.requestMatchers("/Clients").permitAll();
            auth.requestMatchers("/Clients/creer").hasAnyRole("COMMERCIAL","DIR-COM");
            auth.requestMatchers("/Clients/{id}/edition").hasAnyRole("COMMERCIAL","DIR-COM");
            auth.requestMatchers("/Clients/{id}/suppression").hasRole("DIR-COM");
            auth.requestMatchers("/Clients/{id}/detail").permitAll();
            auth.requestMatchers("/produits").permitAll();
            auth.requestMatchers("/produits/creer").hasRole("RES-CAT");
            auth.requestMatchers("/produits/{id}/edition").hasRole("RES-CAT");
            auth.requestMatchers("/produits/{id}/edition-prix").hasRole("RES-CAT");
            auth.requestMatchers("/produits/{id}/suppression").hasRole("RES-CAT");
            auth.requestMatchers("/produits/{id}/detail").permitAll();
            auth.anyRequest().authenticated();
        } ).formLogin(Customizer.withDefaults()).build();
    }

    @Autowired
    private  CustomUserDetailsService customUserDetailsService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
        return authenticationManagerBuilder.build();
    }
}