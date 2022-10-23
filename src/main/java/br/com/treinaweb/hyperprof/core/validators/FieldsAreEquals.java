package br.com.treinaweb.hyperprof.core.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsAreEqualsValidator.class)
public @interface FieldsAreEquals {

    String message() default "deve ser igual ao campo '{field}'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field();
    String fieldMatch();

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldsAreEquals[] value();
    }

}
