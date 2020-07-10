package com.uca.capas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

@Component
public class LogoutEvent implements ApplicationListener<LogoutSuccessEvent> {

    @Autowired
    SessionRegistry sessionRegistry;

    @Override
    public void onApplicationEvent(LogoutSuccessEvent logoutSuccessEvent) {
        sessionRegistry.getAllPrincipals().forEach(p -> {
            sessionRegistry.getAllSessions(p,false).forEach(s-> s.expireNow());
        });
    }

}
