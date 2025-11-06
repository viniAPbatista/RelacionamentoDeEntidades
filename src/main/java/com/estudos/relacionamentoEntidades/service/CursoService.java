package com.estudos.relacionamentoEntidades.service;

import com.estudos.relacionamentoEntidades.dto.request.CadastroCursoRequestDTO;
import com.estudos.relacionamentoEntidades.dto.response.CadastroCursoResponseDTO;
import com.estudos.relacionamentoEntidades.model.Curso;
import com.estudos.relacionamentoEntidades.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public CadastroCursoResponseDTO cadastrarCurso(CadastroCursoRequestDTO cursoRequest) {

        Curso novoCurso = new Curso();
        novoCurso.setNome(cursoRequest.nome());
        novoCurso.setCargaHoraria(cursoRequest.cargaHoraria());

        return new CadastroCursoResponseDTO(
                novoCurso.getIdCurso(),
                novoCurso.getNome(),
                novoCurso.getCargaHoraria()
        );
    }

    public CadastroCursoResponseDTO buscarCurso(UUID id) {

        Curso curso = buscarCursoPeloId(id);

        return new CadastroCursoResponseDTO(
                curso.getIdCurso(),
                curso.getNome(),
                curso.getCargaHoraria()
        );
    }

    public void deletarCurso(UUID id) {

        Curso curso = buscarCursoPeloId(id);

        cursoRepository.delete(curso);
    }

    private Curso buscarCursoPeloId(UUID id) {

        Curso curso = cursoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Curso não encontrado!")
        );

        return curso;
    }
}
