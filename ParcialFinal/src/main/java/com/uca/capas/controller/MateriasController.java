package com.uca.capas.controller;

import com.uca.capas.domain.Materia;
import com.uca.capas.service.MateriaService;
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
public class MateriasController {

    @Autowired
    MateriaService materiaService;

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
            List<Materia> materias = null;
            try {
                materias = materiaService.findAll();
            }catch (Exception e){
                e.printStackTrace();
            }
            mav.addObject("materias", materias);
            mav.addObject("respuesta", "Materia guardada con éxito");
            mav.setViewName("materiasList");
        }
        return mav;
    }


    @RequestMapping (value ="/editMateria/{codigoMateria}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("codigoMateria") int id){
        ModelAndView mav = new ModelAndView();
        Materia materia = null;
        try {
            materia = materiaService.findOne(id);
        }catch(Exception e) {
            e.printStackTrace();
        }
        mav.addObject("materia", materia);
        mav.setViewName("editMateria");
        return mav;
    }

    @PostMapping("/updateMateria")
    public ModelAndView update(@Valid @ModelAttribute Materia materia, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
            mav.setViewName("editMateria");
        }
        else {
            materiaService.edit(materia);
            List<Materia> materias = null;
            try {
                materias = materiaService.findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("respuesta", "Registro actualizado correctamente");
            mav.addObject("materias", materias);
            mav.setViewName("materiasList");
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
}
