package com.uca.capas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

}
