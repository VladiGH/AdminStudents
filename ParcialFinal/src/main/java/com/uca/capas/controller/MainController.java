package com.uca.capas.controller;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Municipio;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.MateriaService;
import com.uca.capas.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/index")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        List<Materia> materias = null;
        try {
            materias = materiaService.findAll();
            mav.addObject("materiaL", materias);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.setViewName("materiasForm");
        mav.addObject("materia", new Materia());
        return mav;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView save(@Valid @ModelAttribute Materia materia, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(!(result.hasErrors())) {
            try{
                materiaService.save(materia);
                mav.setViewName("materiasForm");
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            mav.setViewName("materiasForm");
            //System.out.println(result.getAllErrors().toString());
        }
        return mav;
    }


    @RequestMapping("/listado")
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


    //Centro escolar

    @RequestMapping("/indexCE")
    public ModelAndView inicio2() {
        ModelAndView mav = new ModelAndView();
        List<CentroEscolar> centroEscolars = null;
        List<Municipio> municipios = null;
        try {
            centroEscolars = centroEscolarService.findAll();
            municipios= municipioService.findAll();
            mav.addObject("centroEscolarL", centroEscolars);
            mav.addObject("municipioL",municipios);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.setViewName("centroEscolarForm");
        mav.addObject("centroEscolar", new CentroEscolar());
        return mav;
    }

    @PostMapping("/guardarCentroEscolar")
    public ModelAndView save(@Valid @ModelAttribute CentroEscolar centroEscolar, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(!(result.hasErrors())) {
            try{
                centroEscolarService.save(centroEscolar);
                mav.setViewName("centroEscolarForm");
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            mav.setViewName("centroEscolarForm");
            //System.out.println(result.getAllErrors().toString());
        }
        return mav;
    }


    @RequestMapping("/listadoCentroEscolar")
    public ModelAndView listadoCentroEscolar() {
        ModelAndView mav = new ModelAndView();
        List<CentroEscolar> centroEscolars = null;
        try {
            centroEscolars = centroEscolarService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("centroEscolars", centroEscolars);
        mav.setViewName("centrosEscolaresList");
        return mav;
    }

}
