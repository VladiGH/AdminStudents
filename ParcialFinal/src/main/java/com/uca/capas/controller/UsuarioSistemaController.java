package com.uca.capas.controller;

import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.Rol;
import com.uca.capas.domain.UsuarioSistema;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.RolService;
import com.uca.capas.service.UsuarioSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Secured("ROLE_ADMINISTRADOR")
public class UsuarioSistemaController {

    @Autowired
    MunicipioService municipioService;

    @Autowired
    UsuarioSistemaService userService;

    @Autowired
    RolService rolService;

    @RequestMapping("/ingresoUser")
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
        mav.setViewName("usuarioSistema");
        mav.addObject("municipios", municipiosL);
        mav.addObject("roles",rolesL);
        mav.addObject("user", new UsuarioSistema());
        return mav;
    }

    @RequestMapping(value = "/guardarUsuarioSistema", method = RequestMethod.POST)
    public ModelAndView saveUser(@Valid @ModelAttribute UsuarioSistema user, BindingResult result) {
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
            mav.setViewName("usuarioSistema");
        }else {
            userService.save(user);
            List<UsuarioSistema> usuarios = null;
            try {
                usuarios = userService.findAll();
            }catch (Exception e){
                e.printStackTrace();
            }
            mav.addObject("respuesta","Usuario de sistema ingresado correctamente");
            mav.addObject("users", usuarios);
            mav.setViewName("userList");
        }
        return mav;
    }


    @RequestMapping("/listadoUser")
    public ModelAndView listadoUser() {
        ModelAndView mav = new ModelAndView();
        List<UsuarioSistema> usuarios = null;
        try {
            usuarios = userService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("users", usuarios);
        mav.setViewName("userList");
        return mav;
    }
    @RequestMapping (value ="/editUser/{codigoUser}", method = RequestMethod.POST)
    public ModelAndView editUser(@PathVariable("codigoUser") int id){
        ModelAndView mav = new ModelAndView();
        UsuarioSistema user = null;
        try {
            user = userService.findOne(id);
        }catch(Exception e) {
            e.printStackTrace();
        }
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
        mav.addObject("municipios", municipiosL);
        mav.addObject("user", user);
        mav.addObject("roles",rolesL);
        mav.setViewName("editUser");
        return mav;
    }
    @PostMapping("/updateUser")
    public ModelAndView updateUser(@Valid @ModelAttribute UsuarioSistema user, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
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
            mav.addObject("roles",rolesL);
            mav.addObject("municipios", municipiosL);
            mav.addObject("user", user);
            mav.addObject("respuesta", "Hubo un error al guardar, revisar campos");
            mav.setViewName("editUser");
        }
        else {
            userService.edit(user);
            List<UsuarioSistema> users = null;
            try {
                users = userService.findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("respuesta", "Registro actualizado correctamente");
            mav.addObject("users", users);
            mav.setViewName("userList");
        }
        return mav;
    }
}
