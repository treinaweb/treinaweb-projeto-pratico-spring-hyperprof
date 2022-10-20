package br.com.treinaweb.hyperprof.api.professores.mappers;

import org.springframework.stereotype.Component;

import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorResponse;
import br.com.treinaweb.hyperprof.core.models.Professor;

@Component
public class ProfessorMapperImpl implements ProfessorMapper {

    @Override
    public ProfessorResponse toProfessorResponse(Professor professor) {
        if (professor == null) {
            return null;
        }

        return ProfessorResponse.builder()
            .id(professor.getId())
            .nome(professor.getNome())
            .email(professor.getEmail())
            .idade(professor.getIdade())
            .descricao(professor.getDescricao())
            .valorHora(professor.getValorHora())
            .fotoPerfil(professor.getFotoPerfil())
            .createdAt(professor.getCreatedAt())
            .updatedAt(professor.getUpdatedAt())
            .build();
    }

}
