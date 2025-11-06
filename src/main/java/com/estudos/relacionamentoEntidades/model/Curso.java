package com.estudos.relacionamentoEntidades.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCurso;

    @Column(unique = true)
    private String nome;

    private String cargaHoraria;

    //muitos cursos tem o mesmo professor
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    //Muitos cursos tem a mesma categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "matricula",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Aluno> alunos = new ArrayList<>();
}
