package com.estudos.relacionamentoEntidades.service;

import com.estudos.relacionamentoEntidades.dto.request.CadastroAlunoRequestDTO;
import com.estudos.relacionamentoEntidades.dto.request.MatricularAlunoRequestDTO;
import com.estudos.relacionamentoEntidades.dto.response.CadastroAlunoResponseDTO;
import com.estudos.relacionamentoEntidades.model.Aluno;
import com.estudos.relacionamentoEntidades.model.Curso;
import com.estudos.relacionamentoEntidades.repository.AlunoRepository;
import com.estudos.relacionamentoEntidades.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public CadastroAlunoResponseDTO cadastrarAluno(CadastroAlunoRequestDTO alunoRequest) {

        Aluno novoAluno = new Aluno();
        novoAluno.setNome(alunoRequest.nome());
        novoAluno.setEmail(alunoRequest.email());

        alunoRepository.save(novoAluno);

        return new CadastroAlunoResponseDTO(
                novoAluno.getIdAluno(),
                novoAluno.getNome(),
                novoAluno.getEmail()
        );
    }

    public CadastroAlunoResponseDTO buscarAluno(UUID id) {

        Aluno aluno = buscarAlunoPorId(id);

        return new CadastroAlunoResponseDTO(
                aluno.getIdAluno(),
                aluno.getNome(),
                aluno.getEmail()
        );
    }

    public CadastroAlunoResponseDTO matricularAluno(MatricularAlunoRequestDTO matriculaRequest) {

        Aluno aluno = buscarAlunoPorId(matriculaRequest.idAluno());

        Curso curso = cursoRepository.findById(matriculaRequest.idCurso()).orElseThrow(
                () -> new RuntimeException("Curso não encontrado!")
        );

        curso.getAlunos().add(aluno);
        cursoRepository.save(curso);

        return new CadastroAlunoResponseDTO(
                aluno.getIdAluno(),
                aluno.getNome(),
                aluno.getEmail()
        );
    }

    public void deletarAluno(UUID id) {

        Aluno aluno = buscarAlunoPorId(id);
        alunoRepository.delete(aluno);
    }

    public Aluno buscarAlunoPorId(UUID id) {

        Aluno aluno = alunoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Aluno nao encontrado!")
        );

        return aluno;
    }
}
