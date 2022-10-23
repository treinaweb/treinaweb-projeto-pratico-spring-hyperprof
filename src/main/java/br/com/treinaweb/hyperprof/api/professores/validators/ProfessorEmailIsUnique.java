package br.com.treinaweb.hyperprof.api.professores.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProfessorEmailIsUniqueValidator.class)
public @interface ProfessorEmailIsUnique {

    String message() default "já está em uso";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
