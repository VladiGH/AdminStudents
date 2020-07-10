package com.uca.capas.controller;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Municipio;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.MunicipioService;
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
public class CentroEscolarController {

    @Autowired
    CentroEscolarService centroEscolarService;

    @Autowired
    MunicipioService municipioService;

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
        }else {
            centroEscolarService.save(centroEscolar);
            List<CentroEscolar> centroEscolarL = null;
            try {
                centroEscolarL = centroEscolarService.findAll();
            }catch (Exception e){
                e.printStackTrace();
            }
            mav.addObject("respuesta","Centro Escolar ingresado correctamente");
            mav.addObject("ces", centroEscolarL);
            mav.setViewName("centrosEscolaresList");
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

    @RequestMapping (value ="/editCentroescolar/{codigoCentroEscolar}", method = RequestMethod.POST)
    public ModelAndView editcentroescolar(@PathVariable("codigoCentroEscolar") int id){
        ModelAndView mav = new ModelAndView();
        CentroEscolar ce = null;
        try {
            ce = centroEscolarService.findOne(id);
        }catch(Exception e) {
            e.printStackTrace();
        }
        List<Municipio> municipiosL = null;
        try {
            municipiosL = municipioService.findAll();
        }catch(Exception e) {
            e.printStackTrace();
        }
        mav.addObject("municipios", municipiosL);
        mav.addObject("centroescolar", ce);
        mav.setViewName("editCentroescolar");
        return mav;
    }

    @PostMapping("/updateCentroescolar")
    public ModelAndView updatecentroescolar(@Valid @ModelAttribute CentroEscolar ce, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
        	if(!result.getFieldErrors("nombre").isEmpty()) 
        		mav.addObject("nombres", result.getFieldErrors("nombre").get(0).getDefaultMessage().toString());
        	if(!result.getFieldErrors("descripcion").isEmpty()) 
        		mav.addObject("descripciones", result.getFieldErrors("descripcion").get(0).getDefaultMessage().toString());
        	if(!result.getFieldErrors("direccion").isEmpty()) 
        		mav.addObject("direcciones", result.getFieldErrors("direccion").get(0).getDefaultMessage().toString());
        	
            List<Municipio> municipiosL = null;
            try {
                municipiosL = municipioService.findAll();
            }catch(Exception e) {
                e.printStackTrace();
            }
            mav.addObject("municipios", municipiosL);
            mav.addObject("centroescolar", ce);
            mav.addObject("respuesta", "No se pudo actualizar el registro. Revisar campos");
            mav.setViewName("editCentroescolar");
        }
        else {
            centroEscolarService.edit(ce);
            List<CentroEscolar> ces = null;
            try {
                ces = centroEscolarService.findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("ces", ces);
            mav.addObject("respuesta", "Registro actualizado correctamente");
            mav.setViewName("centrosEscolaresList");
        }
        return mav;
    }
}
