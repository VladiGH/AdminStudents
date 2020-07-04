package com.uca.capas.domain;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public",name="Materia")
public class Materia {
	
    @Id
    @Column(name = "ID_mat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoMateria;

	@Size(max = 10, message="El campo sobrepasa la cantidad de 10 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "nombre")
    private String nombre;

	@Size(max = 50, message="El campo sobrepasa la cantidad de 50 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Boolean estado;
    
	@OneToMany(mappedBy="materia", fetch = FetchType.EAGER)
	private List<MateriasCursadas> cursadas;
    
    public Materia(){

    }

	public Integer getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<MateriasCursadas> getCursadas() {
		return cursadas;
	}

	public void setCursadas(List<MateriasCursadas> cursadas) {
		this.cursadas = cursadas;
	}
	
	public String getEstadoDelegate(){
		if(this.estado == null){
			return "";
		}
		else{
			if(this.estado) return "ACTIVO";
			else return "INACTIVO";
		}
	}

}
