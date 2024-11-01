package com.upiiz.relaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nombre;

    private String correo;
    private String matricula;

    //Un estudiante tiene un perfil
    @OneToOne(targetEntity = Perfil.class)
    private Perfil perfil;

    //Un estudiante tiene un tutor

    @ManyToOne(targetEntity = Tutor.class)
    private Tutor tutor;

    //Un estudiante tiene muchos cursos
    @ManyToMany(targetEntity = Curso.class, fetch = FetchType.LAZY)
    private List<Curso> cursos;
}
