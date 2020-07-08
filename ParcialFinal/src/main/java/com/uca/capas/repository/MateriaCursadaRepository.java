package com.uca.capas.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.MateriasCursadas;

public interface MateriaCursadaRepository extends JpaRepository<MateriasCursadas, Integer> {

}
