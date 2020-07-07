package com.uca.capas.service;

import com.uca.capas.domain.Rol;
import com.uca.capas.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<Rol> findAll() throws DataAccessException {
        return rolRepository.findAll();
    }
}
