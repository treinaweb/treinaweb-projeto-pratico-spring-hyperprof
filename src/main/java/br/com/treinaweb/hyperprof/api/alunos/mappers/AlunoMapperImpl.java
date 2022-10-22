package br.com.treinaweb.hyperprof.api.alunos.mappers;

import org.springframework.stereotype.Component;

import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoRequest;
import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoResponse;
import br.com.treinaweb.hyperprof.core.models.Aluno;

@Component
public class AlunoMapperImpl implements AlunoMapper {

    @Override
    public Aluno toAluno(AlunoRequest alunoRequest) {
        if (alunoRequest == null) {
            return null;
        }

        return Aluno.builder()
            .nome(alunoRequest.getNome())
            .email(alunoRequest.getEmail())
            .dataAula(alunoRequest.getDataAula())
            .build();
    }

    @Override
    public AlunoResponse toAlunoResponse(Aluno aluno) {
        if (aluno == null) {
            return null;
        }

        return AlunoResponse.builder()
            .id(aluno.getId())
            .nome(aluno.getNome())
            .email(aluno.getEmail())
            .dataAula(aluno.getDataAula())
            .createdAt(aluno.getCreatedAt())
            .updatedAt(aluno.getUpdatedAt())
            .build();
    }

}
