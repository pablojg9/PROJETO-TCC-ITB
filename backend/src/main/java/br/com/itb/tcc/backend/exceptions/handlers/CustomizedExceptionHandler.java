package br.com.itb.tcc.backend.exceptions.handlers;

import br.com.itb.tcc.backend.exceptions.BusinessException;
import br.com.itb.tcc.backend.exceptions.ExceptionResponse;
import br.com.itb.tcc.backend.exceptions.ResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RestControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(
                        ex.getMessage(),
                        request.getDescription(false));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ExceptionResponse> handleNotFoundException(ChangeSetPersister.NotFoundException e, WebRequest req) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(e.getMessage(), req.getDescription(true));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(ChangeSetPersister.NotFoundException e, WebRequest req) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(e.getMessage(), req.getDescription(true));

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exceptionResponse);
    }
}
