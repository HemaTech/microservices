package com.student.exceptionhandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * @author anuragdhunna
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setError("NOT_FOUND");
        response.setMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());
      
        response.setStatus("404");
        response.setPath("");
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(InternalServerError ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setError("INTERNAL SERVER EXCEPTION");
        response.setMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());
      
        response.setStatus("500");
        response.setPath("");
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> resourceAlreadyExists(ResourceAlreadyExists ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setError("CONFLICT");
        response.setMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());
        response.setStatus("409");
        response.setPath("");
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> customException(CustomException ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setError("BAD_REQUEST");
        response.setMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());
        response.setStatus("400");
        response.setPath("");
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> unauthorizedException(UnauthorizedException ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setError("UNAUTHORIZED");
        response.setMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());
        response.setStatus("401");
        response.setPath("");
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.UNAUTHORIZED);
    }

}