package com.uca.capas.controller;

import com.uca.capas.domain.Materia;
import com.uca.capas.service.MateriaService;
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
                mav.setViewName("materiasList");
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            mav.setViewName("materiasForm");
            System.out.println(result.getAllErrors().toString());
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

}
