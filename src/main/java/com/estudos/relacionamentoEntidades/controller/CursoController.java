package com.estudos.relacionamentoEntidades.controller;

import com.estudos.relacionamentoEntidades.dto.request.AdicionarCategoriaAoCursoRequestDTO;
import com.estudos.relacionamentoEntidades.dto.request.CadastroCursoRequestDTO;
import com.estudos.relacionamentoEntidades.dto.response.CadastroCursoResponseDTO;
import com.estudos.relacionamentoEntidades.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public CadastroCursoResponseDTO cadastrarCurso(@RequestBody CadastroCursoRequestDTO cursoRequest) {
        return cursoService.cadastrarCurso(cursoRequest);
    }

    @GetMapping("/{id}")
    public CadastroCursoResponseDTO buscarCurso(@PathVariable UUID id) {
        return cursoService.buscarCurso(id);
    }

    @PatchMapping
    public CadastroCursoResponseDTO adicionarCategoriaAoCurso(@RequestBody AdicionarCategoriaAoCursoRequestDTO adicionarRequest) {
        return cursoService.adicionarCategoriaAoCurso(adicionarRequest);
    }

    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable UUID id) {
        cursoService.deletarCurso(id);
    }
}
