package com.uca.capas.Domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(schema = "public",name="estudiante")
public class Estudiante {

    @Id
    @Column(name = "carneMinoridad")
    private Integer codigoEstudiante;

    @Column(name = "nombres")
    private String nombreEstudiante;

    @Column(name="apellidos")
    private String apellidoEstudiante;

    @Column(name = "fecha_nac")
    private Date fechaNaciemiento;

    @Column(name = "edad")
    private int edadEstudiante;

    @Column(name = "direccion")
    private String direccionEstudiante;

    @Column(name = "telefono_fijo")
    private  int telefonoFijoEstudiante;

    @Column(name = "telefono_movil")
    private int telefonoMovilEstudiante;

    @Column(name="nombre_madre")
    private String nombreMadreStudiante;

    @Column(name="nombre_padre")
    private String nombrePadreStudiante;








}
