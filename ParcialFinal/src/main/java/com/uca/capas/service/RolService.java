package com.uca.capas.service;

import com.uca.capas.domain.Rol;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RolService {

    List<Rol> findAll() throws DataAccessException;
}
