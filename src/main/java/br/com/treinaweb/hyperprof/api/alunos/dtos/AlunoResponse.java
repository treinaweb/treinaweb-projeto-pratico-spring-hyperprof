package br.com.treinaweb.hyperprof.api.alunos.dtos;

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
public class AlunoResponse {

    private Long id;
    private String nome;
    private String email;
    private LocalDateTime dataAula;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
