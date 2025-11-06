package com.estudos.relacionamentoEntidades.repository;

import com.estudos.relacionamentoEntidades.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}
