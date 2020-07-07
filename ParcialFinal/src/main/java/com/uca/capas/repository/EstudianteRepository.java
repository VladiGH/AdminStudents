package com.uca.capas.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Estudiante;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

    public List<Estudiante> findByNombreEstudiante(String cadena) throws DataAccessException;

    public List<Estudiante> findByApellidoEstudiante(String cadena) throws DataAccessException;

    public Estudiante findByCodigoEstudiante(String codigoEstudiante);
    @Query(nativeQuery = true, value="select * from public.estudiante")
    public List<Estudiante> mostrarTodos() throws DataAccessException;


}
