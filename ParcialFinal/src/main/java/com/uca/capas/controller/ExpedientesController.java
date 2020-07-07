package com.uca.capas.controller;


import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.UsuarioSistema;
import com.uca.capas.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExpedientesController {

    @Autowired
    EstudianteService estudianteService;


    @RequestMapping("/buscar")
    public ModelAndView inicio3() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("expedienteForm");
        mav.addObject("estudiante", new Estudiante());

        return mav;
    }

    /*@RequestMapping("/buscarEstudiante")
    public ModelAndView buscar(Model model, @ModelAttribute("estudiante") Estudiante estudiante, BindingResult result){
        List<Estudiante> estudiantes =this.estudianteService.filterByNombre(estudiante.getNombreEstudiante());
        model.addAttribute("estudiante",estudiantes);
        return "expediente";
    }
*/

    @RequestMapping(value = "/buscarEstudiante", method = RequestMethod.POST)
    public ModelAndView buscar(@RequestParam(value="nombreEstudiante") String nombre) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteService.filterByNombre(nombre);
            //estudiantes = estudianteService.startWith(nombre);
        }catch(Exception e) {
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("expediente");
        return mav;
    }

    @RequestMapping(value = "/buscarEstudianteApellido", method = RequestMethod.POST)
    public ModelAndView buscarApellido(@RequestParam(value="apellidoEstudiante") String apellido) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteService.filterByApellido(apellido);
            //estudiantes = estudianteService.startWith(nombre);
        }catch(Exception e) {
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("expediente");
        return mav;
    }



}
