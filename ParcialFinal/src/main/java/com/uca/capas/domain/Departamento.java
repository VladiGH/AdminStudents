package com.uca.capas.domain;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(schema = "public",name = "Departamento")

public class Departamento {

    @Id
    @Column(name = "ID_departamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoDepartamento;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "departamento",fetch = FetchType.EAGER)
    private List<Municipio> municipios;
    
    public Departamento() {

    }

    public Integer getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(Integer codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
    
}