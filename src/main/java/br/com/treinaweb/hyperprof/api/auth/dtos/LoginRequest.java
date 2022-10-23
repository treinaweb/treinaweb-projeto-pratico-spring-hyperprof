package br.com.treinaweb.hyperprof.api.auth.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class LoginRequest {

    @Email
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 255)
    private String password;

}
