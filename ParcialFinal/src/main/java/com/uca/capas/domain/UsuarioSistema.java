package com.uca.capas.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name="usuariosistema")
public class UsuarioSistema {

    @Id
    @Column(name = "ID_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoUser;

	@Size(max = 50, message="El campo sobrepasa la cantidad de 50 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "nombre")
    private String nombre;

	@Size(max = 50, message="El campo sobrepasa la cantidad de 50 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name="apellido")
    private String apellido;

	@Size(max = 50, message="El campo sobrepasa la cantidad de 50 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "descripcion")
    private String descripcion;
    
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "fecha_nac")
    private Date fechaNacimiento;

	@Size(max = 100, message="El campo sobrepasa la cantidad de 100 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "direccion")
    private String direccion;
	
    @Column(name = "estado")
    private Boolean estado;
    
    @Column(name = "esAdmin")
    private Boolean esAdmin;
    
	@Size(max = 8, message="El campo sobrepasa la cantidad de 8 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name = "username")
    private String username;

	@Size(max = 10, message="El campo sobrepasa la cantidad de 10 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name="password")
    private String password;
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fkID_municipio")
    private Municipio municipio;
    
    public UsuarioSistema() {
    	
    }

	public Integer getCodigoUser() {
		return codigoUser;
	}

	public void setCodigoUser(Integer codigoUser) {
		this.codigoUser = codigoUser;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(Boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	

}
