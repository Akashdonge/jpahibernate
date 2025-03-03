package com.coding.jpahibernate.jpahibernate.advices;

import com.coding.jpahibernate.jpahibernate.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class golbalexceptioncontroller {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> ResorceNotFound(ResourceNotFoundException e){
        Apierror apierror=Apierror.builder().status(HttpStatus.NOT_FOUND).message(e.getMessage()).build();
        return  BuildErrorResponceEntitiy(apierror);
    }

    private ResponseEntity<ApiResponse<?>> BuildErrorResponceEntitiy(Apierror apierror) {
        return new ResponseEntity<>(new ApiResponse(apierror),apierror.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleinternalservererror(Exception e){
        Apierror apierror=Apierror.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage()).build();
        return  BuildErrorResponceEntitiy(apierror);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<String> erros= e.getBindingResult().getAllErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.toList());
        Apierror apierror=Apierror.builder().status(HttpStatus.BAD_REQUEST).message("Input validation failed ").errors(erros).build();
        return  BuildErrorResponceEntitiy(apierror);
    }

}
