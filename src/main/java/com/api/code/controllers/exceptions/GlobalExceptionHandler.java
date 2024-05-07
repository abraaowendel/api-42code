package com.api.code.controllers.exceptions;

import com.api.code.services.exceptions.DataBaseException;
import com.api.code.services.exceptions.ResourceAlreadyExistsException;
import com.api.code.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        var response = copiarDados(httpStatus, exception.getMessage());
        return ResponseEntity.status(httpStatus).body(response);
    }
//    @ExceptionHandler(UsernameNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(UsernameNotFoundException exception){
//        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
//        var response = copiarDados(httpStatus, exception.getMessage());
//        return ResponseEntity.status(httpStatus).body(response);
//    }
//    @ExceptionHandler(ResourceAlreadyExistsException.class)
//    public ResponseEntity<ErrorDetails> handleResourceAlreadyExistsException(ResourceAlreadyExistsException exception){
//        HttpStatus httpStatus = HttpStatus.CONFLICT;
//        var response = copiarDados(httpStatus, exception.getMessage());
//        return ResponseEntity.status(httpStatus).body(response);
//    }
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<ErrorDetails> handleBadCredentialsException(BadCredentialsException exception){
//        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
//        var response = copiarDados(httpStatus, "Usuário ou Senha incorretos.");
//        return ResponseEntity.status(httpStatus).body(response);
//    }
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<ErrorDetails> handleDataBaseException(DataBaseException exception){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        var response = copiarDados(httpStatus, exception.getMessage());
        return ResponseEntity.status(httpStatus).body(response);
    }

//    @ExceptionHandler(TokenExpiredException.class)
//    public ResponseEntity<ErrorDetails> handleTokenExpiredException(TokenExpiredException exception){
//        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
//        var response = copiarDados(httpStatus, "Token expirado.");
//        return ResponseEntity.status(httpStatus).body(response);
//    }
//
//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity<ErrorDetails> handleAuthenticationException(AuthenticationException exception){
//        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
//        var response = copiarDados(httpStatus, "Username ou Senha inválidos.");
//        return ResponseEntity.status(httpStatus).body(response);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorListResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorListResponse response = new ErrorListResponse();

        response.setStatus(httpStatus);
        response.setMessage("Argumentos inválidos.");
        response.setTimestamp(Instant.now());

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> response.getErrors()
                        .add(new ErrorDetails(httpStatus.value(), error.getDefaultMessage())));

        return ResponseEntity.status(httpStatus).body(response);
    }

    private ErrorDetails copiarDados(HttpStatus status, String message) {
        ErrorDetails error = new ErrorDetails();
        error.setCode(status.value());
        error.setMessage(message);
        return error;
    }

}