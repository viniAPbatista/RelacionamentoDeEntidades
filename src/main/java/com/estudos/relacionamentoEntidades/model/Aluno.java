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
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAluno;

    private String nome;

    @Column(unique = true)
    private String email;

    @ManyToMany(mappedBy = "alunos")                         //Curso é o dono da relação
    private List<Curso> cursos = new ArrayList<>();
}
