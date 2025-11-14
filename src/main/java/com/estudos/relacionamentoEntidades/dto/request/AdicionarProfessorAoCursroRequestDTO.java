package com.estudos.relacionamentoEntidades.dto.request;

import java.util.UUID;

public record AdicionarProfessorAoCursroRequestDTO(UUID idProfessor, UUID idCurso) {
}
