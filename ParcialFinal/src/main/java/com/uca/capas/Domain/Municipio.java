package com.uca.capas.Domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public",name = "Municipio")
public class Municipio {

    @Id
    @Column(name = "ID_municipio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoMunicipio;

    @Column(name="nombre")
    private String nombreMunicipio;

    @OneToMany(mappedBy = "municipio",fetch=FetchType.EAGER)
    private List<Departamento> departamentoList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_ce")
    private CentroEscolar centroEscolar;

    public Municipio() {
    }

    public Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }
}
