package com.uca.capas.service;

import java.util.List;

import com.uca.capas.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	EstudianteRepository estudianteRepository;
	//EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		//return estudianteDAO.findAll();
		return  estudianteRepository.mostrarTodos();
	}

	@Override
	public Estudiante findOne(String code) throws DataAccessException {
		// TODO Auto-generated method stub
		//return estudianteDAO.findOne(code);
		return estudianteRepository.getOne(code);
	}

	@Override
	public void save(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		//estudianteDAO.save(estudiante);
		 estudianteRepository.save(estudiante);
	}

	@Override
	public void edit(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepository.save(estudiante);
	}

	@Override
	public List<Estudiante> filterByNombre(String cadena) throws DataAccessException {
		//return estudianteRepository.findByNombre(cadena);
		return estudianteRepository.findByNombreEstudiante(cadena);
	}

	@Override
	public List<Estudiante> filterByApellido(String cadena) throws DataAccessException {
		//return estudianteRepository.findByNombre(cadena);
		return estudianteRepository.findByApellidoEstudiante(cadena);
	}

	@Override
	public List<Estudiante> getByQueri(Integer tipo, String cadena) throws DataAccessException {
		List<Estudiante> result=null;
		switch (tipo){
			case 1:
				result=estudianteRepository.findByNombreEstudiante(cadena);
				break;
			case 2:
				result=estudianteRepository.findByApellidoEstudiante(cadena);
				break;
		}
		return result;
	}


}
