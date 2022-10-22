package br.com.treinaweb.hyperprof.api.common.handlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;

import br.com.treinaweb.hyperprof.api.common.dtos.ErrorResponse;
import br.com.treinaweb.hyperprof.api.common.dtos.ValidationErrorResponse;
import br.com.treinaweb.hyperprof.core.exceptions.ModelNotFoundException;

@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final SnakeCaseStrategy snakeCaseStrategy = new SnakeCaseStrategy();

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleModelNotFoundException(
        ModelNotFoundException exception, WebRequest request
    ) {
        var status = HttpStatus.NOT_FOUND;
        var body = ErrorResponse.builder()
            .status(status.value())
            .error(status.getReasonPhrase())
            .message(exception.getLocalizedMessage())
            .cause(exception.getClass().getSimpleName())
            .timestamp(LocalDateTime.now())
            .build();
        return new ResponseEntity<ErrorResponse>(body, status);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatusCode statusCode,
        WebRequest request
    ) {
        var status = (HttpStatus) statusCode;
        var errors = new HashMap<String, List<String>>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            var fieldName = snakeCaseStrategy.translate(error.getField());
            var errorMessage = error.getDefaultMessage();
            if (errors.containsKey(fieldName)) {
                errors.get(fieldName).add(errorMessage);
            } else {
                errors.put(fieldName, new ArrayList<String>(Arrays.asList(errorMessage)));
            }
        });
        var body = ValidationErrorResponse.builder()
            .status(status.value())
            .error(status.getReasonPhrase())
            .message("Validation Error")
            .cause(ex.getClass().getSimpleName())
            .timestamp(LocalDateTime.now())
            .errors(errors)
            .build();
        return new ResponseEntity<Object>(body, status);
    }

}
