package com.uca.capas.Domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public",name = "CentroEscolar")
public class CentroEscolar {

    @Id
    @Column(name = "ID_ce")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCentroEscolar;

    @Column(name = "nombre")
    private String nombreCerntroEscolar;

    @Column(name = "descripcion")
    private String descripcionCentroEscolar;

    @Column(name = "direccionCentroEscolar")
    private String direccionCentroEscolar;

    @Column(name = "estado")
    private boolean estadoCentroEscolar;

    @OneToMany(mappedBy = "CentroEscolar",fetch = FetchType.EAGER)
    private List<Municipio> municipiosList;

    public CentroEscolar() {
    }

    public Integer getCodigoCentroEscolar() {
        return codigoCentroEscolar;
    }

    public void setCodigoCentroEscolar(Integer codigoCentroEscolar) {
        this.codigoCentroEscolar = codigoCentroEscolar;
    }

    public String getNombreCerntroEscolar() {
        return nombreCerntroEscolar;
    }

    public void setNombreCerntroEscolar(String nombreCerntroEscolar) {
        this.nombreCerntroEscolar = nombreCerntroEscolar;
    }

    public String getDescripcionCentroEscolar() {
        return descripcionCentroEscolar;
    }

    public void setDescripcionCentroEscolar(String descripcionCentroEscolar) {
        this.descripcionCentroEscolar = descripcionCentroEscolar;
    }

    public String getDireccionCentroEscolar() {
        return direccionCentroEscolar;
    }

    public void setDireccionCentroEscolar(String direccionCentroEscolar) {
        this.direccionCentroEscolar = direccionCentroEscolar;
    }

    public boolean isEstadoCentroEscolar() {
        return estadoCentroEscolar;
    }

    public void setEstadoCentroEscolar(boolean estadoCentroEscolar) {
        this.estadoCentroEscolar = estadoCentroEscolar;
    }

    public List<Municipio> getMunicipiosList() {
        return municipiosList;
    }

    public void setMunicipiosList(List<Municipio> municipiosList) {
        this.municipiosList = municipiosList;
    }
}
