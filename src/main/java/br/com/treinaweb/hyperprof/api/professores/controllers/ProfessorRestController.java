package br.com.treinaweb.hyperprof.api.professores.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.hyperprof.api.common.routes.ApiRoutes;
import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorResponse;
import br.com.treinaweb.hyperprof.api.professores.services.ProfessorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProfessorRestController {

    private final ProfessorService professorService;

    @GetMapping(ApiRoutes.BUSCAR_PROFESSORES)
    public List<ProfessorResponse> buscarProfessores(
        @RequestParam(name = "q", required = false, defaultValue = "") String descricao
    ) {
        return professorService.buscarProfessores(descricao);
    }

    @GetMapping(ApiRoutes.BUSCAR_PROFESSOR_POR_ID)
    public ProfessorResponse buscarProfessorPorId(@PathVariable Long professorId) {
        return professorService.buscarProfessorPorId(professorId);
    }

}
