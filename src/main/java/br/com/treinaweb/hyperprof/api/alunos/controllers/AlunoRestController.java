package br.com.treinaweb.hyperprof.api.alunos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoRequest;
import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoResponse;
import br.com.treinaweb.hyperprof.api.alunos.services.AlunoService;
import br.com.treinaweb.hyperprof.api.common.routes.ApiRoutes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AlunoRestController {

    private final AlunoService alunoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(ApiRoutes.CADASTRAR_ALUNO)
    public AlunoResponse cadastrarAluno(
        @RequestBody @Valid AlunoRequest alunoRequest,
        @PathVariable Long professorId
    ) {
        return alunoService.cadastrarAluno(alunoRequest, professorId);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(ApiRoutes.LISTAR_ALUNOS_POR_PROFESSOR_LOGADO)
    public List<AlunoResponse> listarAlunosPorProfessorLogado() {
        return alunoService.listarAlunosPorProfessorLogado();
    }

}
