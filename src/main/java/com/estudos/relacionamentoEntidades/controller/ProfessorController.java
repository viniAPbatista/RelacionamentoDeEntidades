package com.estudos.relacionamentoEntidades.controller;

import com.estudos.relacionamentoEntidades.dto.request.CadastrarProfessorRequestDTO;
import com.estudos.relacionamentoEntidades.dto.response.CadastroProfessorResponseDTO;
import com.estudos.relacionamentoEntidades.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public CadastroProfessorResponseDTO cadastrarprofessor(CadastrarProfessorRequestDTO professorRequest) {
        return professorService.cadastrarProfessor(professorRequest);
    }

    @GetMapping("/{id}")
    public CadastroProfessorResponseDTO buscarProfessor(@PathVariable UUID id) {
        return professorService.buscarProfessor(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable UUID id) {
        professorService.deletarProfessor(id);
    }
}
