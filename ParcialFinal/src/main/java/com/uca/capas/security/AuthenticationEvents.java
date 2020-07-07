package com.uca.capas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class AuthenticationEvents implements ApplicationListener<AuthenticationSuccessEvent> {



    @Autowired
    SessionRegistry sessionRegistry;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        System.out.println("toy dentro");
        int nUsers = sessionRegistry.getAllPrincipals().stream()
                .filter(u -> !sessionRegistry.getAllSessions(u, false).isEmpty())
                .map(Object::toString)
                .collect(Collectors.toList()).size();
        if(nUsers!=0){
            System.out.println("Ya alguien dentro");
            System.out.println("Tas fuera");
            authenticationSuccessEvent.getAuthentication().setAuthenticated(false);
        }
    }
}
