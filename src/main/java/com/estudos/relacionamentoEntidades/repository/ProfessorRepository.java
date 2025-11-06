package com.estudos.relacionamentoEntidades.repository;

import com.estudos.relacionamentoEntidades.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
}
