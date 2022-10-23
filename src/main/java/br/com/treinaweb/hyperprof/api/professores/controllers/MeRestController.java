package br.com.treinaweb.hyperprof.api.professores.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.hyperprof.api.common.routes.ApiRoutes;
import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorResponse;
import br.com.treinaweb.hyperprof.api.professores.services.MeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MeRestController {

    private final MeService meService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(ApiRoutes.PROFESSOR_LOGADO)
    public ProfessorResponse buscarProfessorLogado() {
        return meService.buscarProfessorLogado();
    }

}
