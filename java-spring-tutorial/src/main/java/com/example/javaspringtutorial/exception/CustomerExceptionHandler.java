package com.example.javaspringtutorial.exception;

import com.example.javaspringtutorial.response.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest request){
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

//    @ExceptionHandler(BindException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseObject handleBindException(BindException e) {
//        return new ResponseObject( e.getBindingResult().getAllErrors().get(0).getDefaultMessage(),"Product name cannot be blank ");
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(BindException e){
        Map<String,String> errorDetail = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errorDetail.put(fieldName, message);
                }
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseApi("Bad request",400,errorDetail));
    }
}
