package br.com.treinaweb.hyperprof.api.professores.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.hyperprof.api.common.dtos.MessageResponse;
import br.com.treinaweb.hyperprof.api.common.routes.ApiRoutes;
import br.com.treinaweb.hyperprof.api.professores.dtos.FotoRequest;
import br.com.treinaweb.hyperprof.api.professores.services.ProfessorFotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProfessorFotoRestController {

    private final ProfessorFotoService professorFotoService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping(ApiRoutes.ATUALIZAR_FOTO_PROFESSOR_LOGADO)
    public MessageResponse atualizarFotoProfessorLogado(
        @ModelAttribute @Valid FotoRequest fotoRequest
    ) {
        return professorFotoService.atualizarFotoProfessorLogado(fotoRequest);
    }

}
