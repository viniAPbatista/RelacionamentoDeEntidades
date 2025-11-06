package com.estudos.relacionamentoEntidades.service;

import com.estudos.relacionamentoEntidades.dto.request.CadastroCategoriaRequestDTO;
import com.estudos.relacionamentoEntidades.dto.response.CadastroCategoriaResponseDTO;
import com.estudos.relacionamentoEntidades.model.Categoria;
import com.estudos.relacionamentoEntidades.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CadastroCategoriaResponseDTO cadastrarCategoria(CadastroCategoriaRequestDTO categoriaRequest) {

        Categoria novaCategoria = new Categoria();
        novaCategoria.setNome(categoriaRequest.nome());

        return new CadastroCategoriaResponseDTO(
                novaCategoria.getIdCategoria(),
                novaCategoria.getNome()
        );
    }

    public CadastroCategoriaResponseDTO buscarCategoria(UUID id) {

        Categoria categoria = buscarCategoriaPeloId(id);

        return new CadastroCategoriaResponseDTO(
                categoria.getIdCategoria(),
                categoria.getNome()
        );
    }

    public void deletarCategoria(UUID id) {

        Categoria categoria = buscarCategoriaPeloId(id);

        categoriaRepository.delete(categoria);
    }

    private Categoria buscarCategoriaPeloId(UUID id) {

        Categoria categoria = categoriaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoria não encontrada!")
        );

        return categoria;
    }
}
