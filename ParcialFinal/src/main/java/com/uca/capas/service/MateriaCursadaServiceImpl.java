package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.MateriaCursadaDAO;
import com.uca.capas.domain.MateriasCursadas;

@Service
public class MateriaCursadaServiceImpl implements MateriaCursadaService{

	@Autowired
	//MateriaCursadaRepo mcRepository; si se usa repo
	MateriaCursadaDAO materiaCDAO;
	
	@Override
	public List<MateriasCursadas> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return materiaCDAO.findAll();
	}

	@Override
	public void save(MateriasCursadas materia) throws DataAccessException {
		// TODO Auto-generated method stub
		materiaCDAO.save(materia);
	}

	@Override
	public MateriasCursadas findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return materiaCDAO.findOne(code);
	}

	@Override
	public void edit(MateriasCursadas materia) throws DataAccessException {
		// TODO Auto-generated method stub
		materiaCDAO.save(materia);
	}

}
