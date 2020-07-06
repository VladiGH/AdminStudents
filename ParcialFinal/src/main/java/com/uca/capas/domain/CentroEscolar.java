package com.uca.capas.domain;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(schema = "public",name = "centroescolar")
public class CentroEscolar {

    @Id
    @Column(name = "ID_ce")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCentroEscolar;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fkID_municipio")
    private	Municipio municipio;

	@OneToMany(mappedBy="centroescolar", fetch = FetchType.LAZY)
	private List<Estudiante> estudiantes;
    

	public CentroEscolar() {
    }

	public Integer getCodigoCentroEscolar() {
		return codigoCentroEscolar;
	}

	public void setCodigoCentroEscolar(Integer codigoCentroEscolar) {
		this.codigoCentroEscolar = codigoCentroEscolar;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
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
    public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

}
