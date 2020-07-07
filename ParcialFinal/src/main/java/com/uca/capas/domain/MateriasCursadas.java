package com.uca.capas.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema = "public", name="materiacursada")
public class MateriasCursadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigomateriacursada")
    private Integer codigoMateriaCursada;

	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "nota")
    private int notaMateriaCursada;

	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "annio")
    private int annioMateriaCursada;

	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "ciclo")
    private int cicloMateriaCursada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codigoMateria")
    private Materia materia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="carneEstudiante")
    private Estudiante estudiante;
    
    public MateriasCursadas() {
    	
    }

	public Integer getCodigoMateriaCursada() {
		return codigoMateriaCursada;
	}

	public void setCodigoMateriaCursada(Integer codigoMateriaCursada) {
		this.codigoMateriaCursada = codigoMateriaCursada;
	}

	public int getNotaMateriaCursada() {
		return notaMateriaCursada;
	}

	public void setNotaMateriaCursada(int notaMateriaCursada) {
		this.notaMateriaCursada = notaMateriaCursada;
	}

	public int getAnnioMateriaCursada() {
		return annioMateriaCursada;
	}

	public void setAnnioMateriaCursada(int annioMateriaCursada) {
		this.annioMateriaCursada = annioMateriaCursada;
	}

	public int getCicloMateriaCursada() {
		return cicloMateriaCursada;
	}

	public void setCicloMateriaCursada(int cicloMateriaCursada) {
		this.cicloMateriaCursada = cicloMateriaCursada;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
    
    
}
