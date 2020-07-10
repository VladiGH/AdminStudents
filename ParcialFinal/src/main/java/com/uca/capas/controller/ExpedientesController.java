package com.uca.capas.controller;


import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.MateriasCursadas;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MateriaCursadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@Secured("ROLE_COORDINADOR")
public class ExpedientesController {

    @Autowired
    MateriaCursadaService materiaCursadaService;

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    CentroEscolarService centroEscolarService;

    @RequestMapping("/buscar")
    public ModelAndView inicio3() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("estudiante", new Estudiante());
        mav.setViewName("studentsList");

        return mav;
    }

    @GetMapping("agregarExpediente")
    public ModelAndView agregarExpedienteForm(){
        ModelAndView mav = new ModelAndView();
        List<CentroEscolar> centros = null;
        try{
            centros = centroEscolarService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("centros",centros);
        mav.setViewName("agregarExpediente");
        mav.addObject("estudiante", new Estudiante());
        return mav;
    }

    @PostMapping("agregarExpediente")
    public ModelAndView agregarExpediente(@Validated @ModelAttribute Estudiante estudiante, BindingResult result){
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()){
            mav = agregarExpedienteForm();
            mav.addObject("estudiante",estudiante);
            return mav;
        }
        try{
            estudianteService.save(estudiante);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("editarExpediente/{codigoEstudiante}")
    public ModelAndView editarExpedienteForm(@PathVariable("codigoEstudiante") String id){
        Estudiante estudiante = null;
        try {
            estudiante = estudianteService.findOne(id);
        }catch(Exception e) {
            e.printStackTrace();
        }
        ModelAndView mav = agregarExpedienteForm();
        mav.setViewName("editarExpediente");
        mav.addObject("estudiante",estudiante);
        String fechaForm = new SimpleDateFormat("yyyy-MM-dd").format((estudiante.getFechaNacimiento()));
        mav.addObject("fechaForm",fechaForm);
        return mav;
    }

    @RequestMapping("/listadoExpedientes")
    public ModelAndView listadoExpedientes() {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("studentsList");
        return mav;
    }

    @RequestMapping(value = "/buscarEstudianteNombre", method = RequestMethod.POST)
    public ModelAndView buscarNombre(@RequestParam(value="nombreEstudiante") String nombre) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteService.filterByNombre(nombre);
            //estudiantes = estudianteService.startWith(nombre);
        }catch(Exception e) {
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("studentsList");
        return mav;
    }

    @RequestMapping(value = "/buscarEstudianteApellido", method = RequestMethod.POST)
    public ModelAndView buscarApellido(@RequestParam(value="filtro") String apellido) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteService.filterByApellido(apellido);
            //estudiantes = estudianteService.startWith(nombre);
        }catch(Exception e) {
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("studentsList");
        return mav;
    }

    @PostMapping("filtrarExpediente")
    public ModelAndView filtro(@RequestParam Integer tipo,@RequestParam String cadena) throws ParseException{
        ModelAndView mav = new ModelAndView();
        if(tipo!=null){
            List<Estudiante> estudianteList =estudianteService.getByQueri(tipo,cadena);
            List<MateriasCursadas> materiasL = null;
            for(Estudiante estu : estudianteList)
            {
                System.out.println(estu.getCodigoEstudiante());
                materiasL=materiaCursadaService.findByName(estu);
                estu.setCursadas(materiasL);
                System.out.println("LASMATERIAS SON:  "+materiasL.size());

            }
            mav.addObject("estu", estudianteList);
        }else{
            System.out.println("No recibi nada bro :C");
        }
        mav.setViewName("studentsList");
        return mav;
    }


}
