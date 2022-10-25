package br.com.treinaweb.hyperprof.core.validators;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {

    private int max;

    @Override
    public void initialize(FileSize constraintAnnotation) {
        max = constraintAnnotation.max();
        validateProperties();
    }

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.getSize() <= convertMegaBytesToBytes(max);
    }

    private int convertMegaBytesToBytes(int value) {
        return value * 1024 * 1024;
    }

    private void validateProperties() {
        if (max <= 0) {
            throw new IllegalArgumentException("O tamanho máximo deve ser maior que zero");
        }
    }

}
