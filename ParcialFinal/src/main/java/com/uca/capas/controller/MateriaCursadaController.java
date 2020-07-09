package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.MateriasCursadas;
import com.uca.capas.domain.Municipio;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MateriaCursadaService;
import com.uca.capas.service.MateriaService;

@Controller
public class MateriaCursadaController {
	@Autowired
	MateriaCursadaService materiaCursadaService;
	
	@Autowired
	EstudianteService estudianteService;
	
	@Autowired
	MateriaService materiaService;
	
	@RequestMapping (value ="/materiacursada/{codigoEstudiante}", method = RequestMethod.GET)
	public ModelAndView materiasCursadas(@PathVariable("codigoEstudiante") String id){
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		float promedio=0;

		try {
			estudiante = estudianteService.findOne(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
        List<MateriasCursadas> materiasL = null;
        try {
			//List<Float> notas = new ArrayList<>();
        	materiasL = materiaCursadaService.findByName(estudiante);
        }catch(Exception e) {
    	   e.printStackTrace();
        }
        mav.addObject("materiascursadas", materiasL);
		mav.addObject("estudiante", estudiante);

		mav.setViewName("materiacursada");
		return mav;
	}	
	@RequestMapping (value ="/ingresoMateriaCursada/{codigoEstudiante}", method = RequestMethod.POST)
	public ModelAndView ingresarMateriaCursada(@PathVariable("codigoEstudiante") String id){
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try {
			estudiante = estudianteService.findOne(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante", estudiante);
        List<Materia> materiasL = null;
        try {
        	materiasL = materiaService.findAll();
        }catch(Exception e) {
    	   e.printStackTrace();
        }
        mav.addObject("materias", materiasL);
		mav.addObject("materiacursada", new MateriasCursadas());
		mav.setViewName("ingresoMateriaCursada");
		return mav;
	}	
    @PostMapping("/guardarMateriaCursada/{codigoEstudiante}")
    public ModelAndView save(@Valid @ModelAttribute MateriasCursadas materia, BindingResult result, @PathVariable("codigoEstudiante") String id) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
    		Estudiante estudiante = null;
    		try {
    			estudiante = estudianteService.findOne(id);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
            List<Materia> materiasL = null;
            try {
            	materiasL = materiaService.findAll();
            }catch(Exception e) {
        	   e.printStackTrace();
            }
            mav.addObject("materias", materiasL);
    		mav.addObject("estudiante", estudiante);
    		mav.addObject("respuesta", "No se pudo ingresar el registro");
    		mav.addObject("materiacursada", materia);
			mav.setViewName("ingresoMateriaCursada");
		}else {
	        Estudiante estudiante = null;
			try {
				estudiante = estudianteService.findOne(id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			materia.setEstudiante(estudiante);
			materiaCursadaService.save(materia);
	        List<MateriasCursadas> materiasL = null;
	        try {
	        	materiasL = materiaCursadaService.findAll();
	        }catch(Exception e) {
	    	   e.printStackTrace();
	        }

			mav.addObject("estudiante", estudiante);
			mav.addObject("respuesta", "Materia Cursada guardada con éxito");
	        mav.addObject("materiascursadas", materiasL);
			mav.setViewName("materiacursada");
		}
        return mav;
    }
    
	@RequestMapping (value ="/editMateriaCursada/{codigoMateriaCursada}", method = RequestMethod.POST)
	public ModelAndView editMateriaCursada(@PathVariable("codigoMateriaCursada") int id){
		ModelAndView mav = new ModelAndView();
		MateriasCursadas materia = null;
        List<Materia> materiasL = null;
        Estudiante estudiante = null;
		try {
			materia = materiaCursadaService.findOne(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
        try {
        	materiasL = materiaService.findAll();
        }catch(Exception e) {
    	   e.printStackTrace();
        }
        try {
        	estudiante = estudianteService.findOne(materia.getEstudiante().getCodigoEstudiante());
        }catch(Exception e) {
    	   e.printStackTrace();
        }
        mav.addObject("estudiante", estudiante);
        mav.addObject("materias", materiasL);
		mav.addObject("materia", materia);
		mav.setViewName("editMateriaCursada");
		return mav;
	}
	
	@PostMapping("/updateMateriaCursada/{codigoEstudiante}")
	public ModelAndView update(@Valid @ModelAttribute MateriasCursadas materia, BindingResult result,@PathVariable("codigoEstudiante") String id) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			MateriasCursadas materiaC = null;
    		Estudiante estudiante = null;
            List<Materia> materiasL = null;
    		try {
    			materiaC = materiaCursadaService.findOne(materia.getCodigoMateriaCursada());
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		try {
    			estudiante = estudianteService.findOne(id);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
            try {
            	materiasL = materiaService.findAll();
            }catch(Exception e) {
        	   e.printStackTrace();
            }

            mav.addObject("materia", materiaC);
            mav.addObject("materias", materiasL);
    		mav.addObject("estudiante", estudiante);
    		mav.addObject("respuesta", "No se pudo ingresar el registro");
    		mav.addObject("materiacursada", materia);
			mav.setViewName("editMateriaCursada");
		}
		else {
	        Estudiante estudiante = null;
			try {
				estudiante = estudianteService.findOne(id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			materia.setEstudiante(estudiante);
			materiaCursadaService.save(materia);
	        List<MateriasCursadas> materiasL = null;
	        try {
	        	materiasL = materiaCursadaService.findAll();
	        }catch(Exception e) {
	    	   e.printStackTrace();
	        }

			mav.addObject("estudiante", estudiante);
			mav.addObject("respuesta", "Materia Cursada guardada con éxito");
	        mav.addObject("materiascursadas", materiasL);
			mav.setViewName("materiacursada");
		}
		return mav;
	}
}
