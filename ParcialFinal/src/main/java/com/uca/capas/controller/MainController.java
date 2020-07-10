package com.uca.capas.controller;

import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.Rol;
import com.uca.capas.domain.UsuarioSistema;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.RolService;
import com.uca.capas.service.UsuarioSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    MunicipioService municipioService;

    @Autowired
    UsuarioSistemaService userService;

    @Autowired
    RolService rolService;

    @RequestMapping("/index")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView loginPage(@RequestParam(value = "error",required = false)String error){
        ModelAndView mav = new ModelAndView();
        if(error!=null){
            String errorMsg;
            switch (error){
                case "User is disabled":
                    errorMsg = "Su usario no esta activado, contacte al administrador";
                    break;
                    case "Bad credentials":
                            errorMsg = "Credenciales incorrectas";
                            break;
                default:
                    errorMsg = "Error al intentar iniciar sesión";
            }
            mav.addObject("errorMsg",errorMsg);
        }
        mav.setViewName("/login");
        return mav;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("login-error")
    public ModelAndView error(){
        System.out.println("hola");
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg","Ya hay un usuario utilizando el sistema");
        mav.setViewName("/login");
        return mav;
    }

    @GetMapping("register")
    public ModelAndView inicio3() {
        ModelAndView mav = new ModelAndView();
        List<Municipio> municipiosL = null;
        try {
            municipiosL = municipioService.findAll();
        }catch(Exception e) {
            e.printStackTrace();
        }
        List<Rol> rolesL = null;
        try{
            rolesL = rolService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.setViewName("register");
        mav.addObject("municipios", municipiosL);
        mav.addObject("roles",rolesL);
        mav.addObject("user", new UsuarioSistema());
        return mav;
    }

    @PostMapping("register")
    public ModelAndView saveUser(@Valid @ModelAttribute UsuarioSistema user, BindingResult result) {
        System.out.println("hola");
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
            List<Municipio> municipiosL = null;
            try {
                municipiosL = municipioService.findAll();
            }catch(Exception e) {
                e.printStackTrace();
            }
            mav.addObject("municipios", municipiosL);
            mav.addObject("user", user);
            mav.addObject("respuesta", "Hubo un error al guardar, revisar campos");
            mav.setViewName("register");
        }else {
            user.setEstado(false);
            userService.save(user);
            List<UsuarioSistema> usuarios = null;
            try {
                usuarios = userService.findAll();
            }catch (Exception e){
                e.printStackTrace();
            }
            mav.addObject("msg","Registro realizado con exito!");
            mav.setViewName("login");
        }
        return mav;
    }

}
