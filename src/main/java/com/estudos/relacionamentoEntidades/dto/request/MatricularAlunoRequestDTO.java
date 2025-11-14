package com.estudos.relacionamentoEntidades.dto.request;

import java.util.UUID;

public record MatricularAlunoRequestDTO(UUID idAluno, UUID idCurso) {
}
