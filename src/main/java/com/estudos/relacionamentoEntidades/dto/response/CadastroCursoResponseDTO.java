package com.estudos.relacionamentoEntidades.dto.response;

import java.util.UUID;

public record CadastroCursoResponseDTO(UUID id, String nome, String cargaHoraria) {
}
