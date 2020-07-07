package com.uca.capas.controller;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Estudiante;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        
        mav.addObject("municipios", municipiosL);
		mav.addObject("user", user);
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
