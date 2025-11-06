package com.estudos.relacionamentoEntidades.controller;

import com.estudos.relacionamentoEntidades.dto.request.CadastroAlunoRequestDTO;
import com.estudos.relacionamentoEntidades.dto.response.CadastroAlunoResponseDTO;
import com.estudos.relacionamentoEntidades.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public CadastroAlunoResponseDTO cadastrarAluno(CadastroAlunoRequestDTO alunoRequest) {
        return alunoService.cadastrarAluno(alunoRequest);
    }

    @GetMapping("/{id}")
    public CadastroAlunoResponseDTO buscarAluno(@PathVariable UUID id) {
        return alunoService.buscarAluno(id);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable UUID id) {
        alunoService.deletarAluno(id);
    }
}
