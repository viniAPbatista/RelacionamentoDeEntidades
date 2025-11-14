package com.estudos.relacionamentoEntidades.controller;

import com.estudos.relacionamentoEntidades.dto.request.CadastroCategoriaRequestDTO;
import com.estudos.relacionamentoEntidades.dto.response.CadastroCategoriaResponseDTO;
import com.estudos.relacionamentoEntidades.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public CadastroCategoriaResponseDTO cadastrarCategoria(@RequestBody CadastroCategoriaRequestDTO categoriaRequest) {
        return categoriaService.cadastrarCategoria(categoriaRequest);
    }

    @GetMapping("/{id}")
    public CadastroCategoriaResponseDTO buscarCategoria(@PathVariable UUID id) {
        return categoriaService.buscarCategoria(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable UUID id) {
        categoriaService.deletarCategoria(id);
    }
}
