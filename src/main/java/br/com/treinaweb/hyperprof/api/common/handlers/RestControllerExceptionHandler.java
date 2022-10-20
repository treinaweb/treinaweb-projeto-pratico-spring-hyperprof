package br.com.treinaweb.hyperprof.api.common.handlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.treinaweb.hyperprof.api.common.dtos.ErrorResponse;
import br.com.treinaweb.hyperprof.core.exceptions.ModelNotFoundException;

@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

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

}
