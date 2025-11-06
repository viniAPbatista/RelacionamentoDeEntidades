package com.estudos.relacionamentoEntidades.repository;

import com.estudos.relacionamentoEntidades.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<Curso, UUID> {
}
