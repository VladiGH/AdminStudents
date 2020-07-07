package com.uca.capas.controller;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.UsuarioSistema;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.MateriaService;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.UsuarioSistemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    MateriaService materiaService;

    @Autowired
    CentroEscolarService centroEscolarService;

    @Autowired
    MunicipioService municipioService;
    
    @Autowired
    UsuarioSistemaService userService;
    

    @RequestMapping("/index")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
    
    @RequestMapping("/ingresoMateria")
    public ModelAndView ingresoMateria() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("materiasForm");
        mav.addObject("materia", new Materia());
        return mav;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView save(@Valid @ModelAttribute Materia materia, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
			mav.setViewName("materiasForm");
		}else {
			materiaService.save(materia);
			mav.addObject("respuesta", "Materia guardada con éxito");
			mav.setViewName("index");
		}
        return mav;
    }


    @RequestMapping("/listadoMateria")
    public ModelAndView listado() {
        ModelAndView mav = new ModelAndView();
        List<Materia> materias = null;
        try {
            materias = materiaService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("materias", materias);
        mav.setViewName("materiasList");
        return mav;
    }

//TODO:-----------------------------------------------------------------------------
    //Centro escolar

    @RequestMapping("/ingresoCentroEscolar")
    public ModelAndView inicio2() {
        ModelAndView mav = new ModelAndView();
        List<Municipio> municipiosL = null;
       try {
    	   municipiosL = municipioService.findAll();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
        mav.setViewName("centroEscolarForm");
        mav.addObject("municipios", municipiosL);
        mav.addObject("centroEscolar", new CentroEscolar());
        
        return mav;
    }

    @PostMapping("/guardarCentroEscolar")
    public ModelAndView save(@Valid @ModelAttribute CentroEscolar centroEscolar, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
        	List<Municipio> municipiosL = null;
            try {
         	   municipiosL = municipioService.findAll();
            }catch(Exception e) {
         	   e.printStackTrace();
            }
            mav.addObject("municipios", municipiosL);
        	mav.setViewName("centroEscolarForm");
        	System.out.println(result.toString());
		}else {
			centroEscolarService.save(centroEscolar);
            mav.addObject("respuesta","Centro Escolar ingresado correctamente");
            mav.setViewName("index");
		}
        return mav;
    }


    @RequestMapping("/listadoCentroEscolar")
    public ModelAndView listadoCentroEscolar() {
        ModelAndView mav = new ModelAndView();
        List<CentroEscolar> centroEscolarL = null;
        try {
            centroEscolarL = centroEscolarService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("ces", centroEscolarL);
        mav.setViewName("centrosEscolaresList");
        return mav;
    }
//TODO:------------------------------------------------------------------------
    //Usuario de Sismte

    @RequestMapping("/ingresoUser")
    public ModelAndView inicio3() {
        ModelAndView mav = new ModelAndView();
        List<Municipio> municipiosL = null;
       try {
    	   municipiosL = municipioService.findAll();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
        mav.setViewName("usuarioSistema");
        mav.addObject("municipios", municipiosL);
        mav.addObject("usuariosistema", new UsuarioSistema());
        
        return mav;
    }

    @RequestMapping(value = "/guardarUsuarioSistema", method = RequestMethod.POST)
    public ModelAndView saveUser(@Valid @ModelAttribute UsuarioSistema user, BindingResult result, HttpServletRequest request) {

    	ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
        	List<Municipio> municipiosL = null;
            try {
         	   municipiosL = municipioService.findAll();
            }catch(Exception e) {
         	   e.printStackTrace();
            }
            mav.addObject("municipios", municipiosL);
        	mav.setViewName("usuarioSistema");
        	System.out.println(result.toString());
		}else {
			userService.save(user);
            mav.addObject("respuesta","Usuario de sistema ingresado correctamente");
            mav.setViewName("index");
		}
        return mav;
    }


    @RequestMapping("/listadoUser")
    public ModelAndView listadoUser() {
        ModelAndView mav = new ModelAndView();
        List<UsuarioSistema> userL = null;
        try {
        	userL = userService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("usuarios", userL);
        mav.setViewName("UsuarioSistemaList");
        return mav;
    }
}
