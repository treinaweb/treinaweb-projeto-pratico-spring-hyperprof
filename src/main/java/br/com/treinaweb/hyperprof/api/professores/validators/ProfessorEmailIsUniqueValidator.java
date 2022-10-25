package br.com.treinaweb.hyperprof.api.professores.validators;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.treinaweb.hyperprof.core.repositories.ProfessorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProfessorEmailIsUniqueValidator implements ConstraintValidator<ProfessorEmailIsUnique, String> {

    private final ProfessorRepository professorRepository;

    @Override
    @SuppressWarnings("null")
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var isAuthenticated = authentication != null
            && !(authentication instanceof AnonymousAuthenticationToken)
            && authentication.isAuthenticated();
        if (isAuthenticated) {
            var professor = professorRepository.findByEmail(value);
            return professor.isEmpty() || professor.get().getEmail().equals(authentication.getName());
        }
        return !professorRepository.existsByEmail(value);
    }

}
