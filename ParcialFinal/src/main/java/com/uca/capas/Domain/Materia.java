package com.uca.capas.Domain;


import javax.persistence.*;

@Entity
@Table(schema = "public",name="Materia")
public class Materia {
    @Id
    @Column(name = "ID_mat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoMateria;

    @Column(name = "nombre")
    private String nombreMateria;

    @Column(name = "descripcion")
    private String descripcionMateria;

    @Column(name = "estado")
    private String estadoMateria;

    public Materia(){

    }

    public Integer getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Integer codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public String getEstadoMateria() {
        return estadoMateria;
    }

    public void setEstadoMateria(String estadoMateria) {
        this.estadoMateria = estadoMateria;
    }
}
