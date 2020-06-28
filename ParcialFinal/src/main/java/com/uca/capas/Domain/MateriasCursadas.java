package com.uca.capas.Domain;


import javax.persistence.*;

@Entity
@Table(schema = "public",name="MateriaaCursadas")
public class MateriasCursadas {

    @Id
    @Column(name = "ID_mate")
    private Integer codigoMateria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_mat")
    private Materia materia;


    @Id
    @Column(name = "carneMinoridad")
    private Integer codigoEstudiante;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="carneMinoridad")
    private Estudiante estudiante;

    @Column(name = "nota")
    private int notaMateriaCursada;

    @Column(name = "ano")
    private int anoMateriaCursada;

    @Column(name = "ciclo")
    private int cicloMateriaCursada;


}
