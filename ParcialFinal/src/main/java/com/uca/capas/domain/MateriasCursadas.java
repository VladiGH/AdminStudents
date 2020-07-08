package com.uca.capas.domain;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name="materiacursada")
public class MateriasCursadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigomateriacursada")
    private Integer codigoMateriaCursada;

	@NotNull(message="Este campo no puede quedar vacio")
	@Min(value=0, message="Notas del 0.0-10-0")
	@Max(value=10,  message="Notas del 0.0-10-0")
    @Column(name = "nota")
    private Float notaMateriaCursada;

	@NotNull(message="Este campo no puede quedar vacio")
	@Min(value=2005, message="Annio invalido. Minimo = 2005")
	@Max(value=2020, message="Annio invalido. Minimo = 2020")
    @Column(name = "annio")
    private Integer annioMateriaCursada;

	@NotNull(message="Este campo no puede quedar vacio")
	@Min(value=1, message="Ciclos validos = 01, 02, 03")
	@Max(value=3, message="Ciclos validos = 01, 02, 03")
    @Column(name = "ciclo")
    private Integer cicloMateriaCursada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codigomateria")
    private Materia materia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codigoestudiante")
    private Estudiante estudiante;
    
    public MateriasCursadas() {
    	
    }

	public Integer getCodigoMateriaCursada() {
		return codigoMateriaCursada;
	}

	public void setCodigoMateriaCursada(Integer codigoMateriaCursada) {
		this.codigoMateriaCursada = codigoMateriaCursada;
	}

	public Float getNotaMateriaCursada() {
		return notaMateriaCursada;
	}

	public void setNotaMateriaCursada(Float notaMateriaCursada) {
		this.notaMateriaCursada = notaMateriaCursada;
	}
	
	public Integer getCicloMateriaCursada() {
		return cicloMateriaCursada;
	}

	public void setCicloMateriaCursada(Integer cicloMateriaCursada) {
		this.cicloMateriaCursada = cicloMateriaCursada;
	}

	public Integer getAnnioMateriaCursada() {
		return annioMateriaCursada;
	}

	public void setAnnioMateriaCursada(Integer annioMateriaCursada) {
		this.annioMateriaCursada = annioMateriaCursada;
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
	public String getNotaDelegate(){
		if(this.notaMateriaCursada < 6.0){
			return "REPROBADA";
		}
		else{
			return "APROBADA";
		}
	}
    
}
