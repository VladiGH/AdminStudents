package com.uca.capas.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    @RequestMapping("/index")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView loginPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/login");
        return mav;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("login-error")
    public ModelAndView error(){
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg","Ya hay un usuario logeado en el sistema");
        mav.setViewName("/login");
        return mav;
    }

}
