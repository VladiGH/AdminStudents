package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.UsuarioSistemaDAO;
import com.uca.capas.domain.UsuarioSistema;

@Service
public class UsuarioSistemaServiceImpl implements UsuarioSistemaService {
	
	@Autowired
	//userRepository userRepository; si se usa repo
	UsuarioSistemaDAO usuarioDAO;
	
	@Override
	public List<UsuarioSistema> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return usuarioDAO.findAll();
	}

	@Override
	public void save(UsuarioSistema user) throws DataAccessException {
		// TODO Auto-generated method stub
		usuarioDAO.save(user);
	}

	@Override
	public void edit(UsuarioSistema user) throws DataAccessException {
		// TODO Auto-generated method stub
		usuarioDAO.save(user);
	}

	@Override
	public UsuarioSistema findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return usuarioDAO.findOne(code);
	}

}
