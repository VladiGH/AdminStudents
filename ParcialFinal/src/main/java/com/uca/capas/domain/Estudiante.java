package com.uca.capas.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "public",name="estudiante")
public class Estudiante {

    @Id
	@Size(max = 9, min = 9, message="El campo no es igual a 9 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "carneminoridad")
    private String codigoEstudiante;

	@Size(max = 50, message="El campo sobrepasa la cantidad de 50 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "nombres")
    private String nombreEstudiante;

	@Size(max = 50, message="El campo sobrepasa la cantidad de 50 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name="apellidos")
    private String apellidoEstudiante;

    @Column(name = "fecha_nac")
	@NotNull(message = "La fecha no debe estar vacia")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fechaNacimiento;

	@Size(max = 100, message="El campo sobrepasa la cantidad de 100 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "direccion")
    private String direccion;

	@NotEmpty(message="Este campo no puede quedar vacio")
	@Pattern(regexp = "^\\d{4}\\-\\d{4}$",message = "El telefono no cumple con el formato establecido")
    @Column(name = "telefono_fijo")
    private  String telefonoFijo;

	@NotEmpty(message="Este campo no puede quedar vacio")
	@Pattern(regexp = "^\\d{4}\\-\\d{4}$",message = "El telefono no cumple con el formato establecido")
    @Column(name = "telefono_movil")
    private String telefonoMovil;

	@Size(max = 50, message="El campo sobrepasa la cantidad de 50 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name="nombre_madre")
    private String nombreMadre;

	@Size(max = 50, message="El campo sobrepasa la cantidad de 50 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name="nombre_padre")
    private String nombrePadre;

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_ce")
    private	CentroEscolar centroescolar;

	@OneToMany(mappedBy="estudiante", fetch = FetchType.LAZY)
	private List<MateriasCursadas> cursadas;
    
    public Estudiante() {
    	
    }

	public String getCodigoEstudiante() {
		return codigoEstudiante;
	}

	public void setCodigoEstudiante(String codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getApellidoEstudiante() {
		return apellidoEstudiante;
	}

	public void setApellidoEstudiante(String apellidoEstudiante) {
		this.apellidoEstudiante = apellidoEstudiante;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public CentroEscolar getCentroescolar() {
		return centroescolar;
	}

	public void setCentroescolar(CentroEscolar centroescolar) {
		this.centroescolar = centroescolar;
	}

	public List<MateriasCursadas> getCursadas() {
		return cursadas;
	}

	public void setCursadas(List<MateriasCursadas> cursadas) {
		this.cursadas = cursadas;
	}

	public int getAprobadasDelegate(){
    	int aprobada=0;
		for(MateriasCursadas mc: cursadas){

			if(mc.getNotaMateriaCursada()>=6){
				aprobada++;
			}

		}
		return aprobada;
	}

	public int getReprobadasDelegate(){
		int reprobada=0;
		for(MateriasCursadas mc: cursadas){

			if(mc.getNotaMateriaCursada()<6){
				reprobada++;
			}

		}
		return reprobada;
	}

	public float getPromedio(){
    	float promedio=0,aux=0,suma=0;

    	if(cursadas.size()==0){
    		return 0;
		}

		for(MateriasCursadas mc: cursadas){

			suma+=mc.getNotaMateriaCursada();
		}
		aux=cursadas.size();
		promedio=suma/aux;
		return promedio;
	}

}
