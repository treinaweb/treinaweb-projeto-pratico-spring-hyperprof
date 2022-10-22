package br.com.treinaweb.hyperprof.api.alunos.mappers;

import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoRequest;
import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoResponse;
import br.com.treinaweb.hyperprof.core.models.Aluno;

public interface AlunoMapper {

    Aluno toAluno(AlunoRequest alunoRequest);
    AlunoResponse toAlunoResponse(Aluno aluno);

}
