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
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String escolaridad;

    //Un tutor tiene muchos estudiantes
    @OneToMany(targetEntity = Estudiante.class, fetch = FetchType.LAZY, mappedBy = "tutor") //LAZY me muestra los estudiantes solo cuando los mande a llamar
    private List<Estudiante> estudiantes;

}