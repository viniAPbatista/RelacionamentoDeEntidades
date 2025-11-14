package com.estudos.relacionamentoEntidades.dto.request;

import java.util.UUID;

public record AdicionarCategoriaAoCursoRequestDTO(UUID idCurso, UUID idCategoria) {
}
