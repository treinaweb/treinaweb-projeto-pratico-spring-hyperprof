package br.com.treinaweb.hyperprof.core.validators;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldsAreEqualsValidator implements ConstraintValidator<FieldsAreEquals, Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(FieldsAreEquals constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
        validateParameters();
    }

    @Override
    @SuppressWarnings("null")
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode(fieldMatch)
            .addConstraintViolation();
        var fieldPropertyDescriptor = BeanUtils.getPropertyDescriptor(value.getClass(), field);
        var fieldMatchPropertyDescriptor = BeanUtils.getPropertyDescriptor(value.getClass(), fieldMatch);
        if (fieldMatchPropertyDescriptor == null || fieldMatchPropertyDescriptor == null) {
            throw new IllegalArgumentException("Os campos informados não existem na classe");
        }
        try {
            var fieldValue = fieldPropertyDescriptor.getReadMethod().invoke(value);
            var fieldMatchValue = fieldMatchPropertyDescriptor.getReadMethod().invoke(value);
            return Objects.equals(fieldValue, fieldMatchValue);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Não foi possivel acessar os campos informados");
        }
    }

    private void validateParameters() {
        if (field == null || field.isEmpty()) {
            throw new IllegalArgumentException("O campo 'field' não pode ser nulo ou vazio");
        }

        if (fieldMatch == null || fieldMatch.isEmpty()) {
            throw new IllegalArgumentException("O campo 'fieldMatch' não pode ser nulo ou vazio");
        }
    }

}
