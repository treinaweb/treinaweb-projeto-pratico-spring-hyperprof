package br.com.treinaweb.hyperprof.core.validators;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsImageValidator implements ConstraintValidator<IsImage, MultipartFile> {

    @Override
    @SuppressWarnings("null")
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.getContentType().startsWith("image/");
    }

}
