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
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCategoria;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria")                  //uma categoria pode ter varios cursos, curso dono da relação
    private List<Curso> cursos = new ArrayList<>();
}
