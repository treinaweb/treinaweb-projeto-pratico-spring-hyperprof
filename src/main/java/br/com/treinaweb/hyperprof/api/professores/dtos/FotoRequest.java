package br.com.treinaweb.hyperprof.api.professores.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import br.com.treinaweb.hyperprof.core.validators.FileSize;
import br.com.treinaweb.hyperprof.core.validators.IsImage;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class FotoRequest {

    @NotNull
    @IsImage
    @FileSize
    private MultipartFile foto;

}
