package com.uca.capas.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public",name = "municipio")
public class Municipio {

    @Id
    @Column(name = "id_municipio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoMunicipio;

    @Column(name="nombre")
    private String nombre;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_departamento")
    private Departamento departamento;

    @OneToMany(mappedBy="municipio", fetch = FetchType.LAZY)
    private List<CentroEscolar> centrosEscolares;

    @OneToMany(mappedBy="municipio", fetch = FetchType.LAZY)
    private List<UsuarioSistema> usuarios;
    
    public Municipio() {
    }

	public Integer getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(Integer codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<CentroEscolar> getCentrosEscolares() {
		return centrosEscolares;
	}

	public void setCentrosEscolares(List<CentroEscolar> centrosEscolares) {
		this.centrosEscolares = centrosEscolares;
	}

	public List<UsuarioSistema> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioSistema> usuarios) {
		this.usuarios = usuarios;
	}

}
