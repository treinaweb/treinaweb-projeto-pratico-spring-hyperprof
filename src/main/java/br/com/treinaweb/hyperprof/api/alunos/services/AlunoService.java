package br.com.treinaweb.hyperprof.api.alunos.services;

import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoRequest;
import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoResponse;

public interface AlunoService {

    AlunoResponse cadastrarAluno(AlunoRequest alunoRequest, Long professorId);

}
