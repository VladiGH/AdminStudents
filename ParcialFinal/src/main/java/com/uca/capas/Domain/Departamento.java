package com.uca.capas.Domain;


import javax.persistence.*;

@Entity
@Table(schema = "public",name = "Departamento")

public class Departamento {

    @Id
    @Column(name = "ID_departamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoDepartamento;

    @Column(name = "nombre")
    private String nombreDepartamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_municipio")
    private Municipio municipio;

    public Municipio getMunicipio() {

        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Departamento() {

    }

    public Integer getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(Integer codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}
