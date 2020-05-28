package az.itstep.pp.resource;


import az.itstep.pp.exception.DomainUpdateException;
import az.itstep.pp.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.awt.*;

@ControllerAdvice
public class PaymentProxyExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<?> handleConflict(NotFoundException ex, WebRequest request){
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(ex.getMessage());
    }
    @ExceptionHandler(DomainUpdateException.class)
    protected  ResponseEntity<?> handleConflict(DomainUpdateException ex,WebRequest request){
        ex.printStackTrace();
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(ex.getMessage());
    }

}
