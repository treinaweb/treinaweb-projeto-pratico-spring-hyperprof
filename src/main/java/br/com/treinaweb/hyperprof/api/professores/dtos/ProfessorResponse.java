package br.com.treinaweb.hyperprof.api.professores.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class ProfessorResponse {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String descricao;
    private BigDecimal valorHora;
    private String fotoPerfil;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
