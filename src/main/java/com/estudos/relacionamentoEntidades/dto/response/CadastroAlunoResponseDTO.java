package com.estudos.relacionamentoEntidades.dto.response;

import java.util.UUID;

public record CadastroAlunoResponseDTO (UUID id, String nome, String email){
}
