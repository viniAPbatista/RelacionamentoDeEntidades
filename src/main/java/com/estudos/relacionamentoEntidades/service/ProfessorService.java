package com.estudos.relacionamentoEntidades.service;

import com.estudos.relacionamentoEntidades.dto.request.CadastrarProfessorRequestDTO;
import com.estudos.relacionamentoEntidades.dto.response.CadastroProfessorResponseDTO;
import com.estudos.relacionamentoEntidades.model.Professor;
import com.estudos.relacionamentoEntidades.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public CadastroProfessorResponseDTO cadastrarProfessor(CadastrarProfessorRequestDTO professorRequest) {

        Professor novoProfessor = new Professor();
        novoProfessor.setNome(professorRequest.nome());
        novoProfessor.setEspecialidade(professorRequest.especialidade());

        return new CadastroProfessorResponseDTO(
                novoProfessor.getIdProfessor(),
                novoProfessor.getNome(),
                novoProfessor.getEspecialidade()
        );
    }

    public CadastroProfessorResponseDTO buscarProfessor(UUID id) {

        Professor professor = buscarProfessorPeloId(id);

        return new CadastroProfessorResponseDTO(
                professor.getIdProfessor(),
                professor.getNome(),
                professor.getEspecialidade()
        );
    }

    public void deletarProfessor(UUID id) {

        Professor professor = buscarProfessorPeloId(id);

        professorRepository.delete(professor);
    }

    private Professor buscarProfessorPeloId(UUID id) {

        Professor professor = professorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Professor não encontrado!")
        );

        return professor;
    }
}
