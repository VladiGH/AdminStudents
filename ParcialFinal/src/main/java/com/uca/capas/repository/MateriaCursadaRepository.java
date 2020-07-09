package com.uca.capas.repository;

import java.util.List;

import com.uca.capas.domain.Estudiante;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.MateriasCursadas;

import javax.xml.crypto.Data;

public interface MateriaCursadaRepository extends JpaRepository<MateriasCursadas, Integer> {

    List<MateriasCursadas> findByEstudiante(Estudiante estudiante) throws DataAccessException;

}
