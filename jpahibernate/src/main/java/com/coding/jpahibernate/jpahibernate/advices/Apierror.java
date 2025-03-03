package com.coding.jpahibernate.jpahibernate.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class Apierror {
    private HttpStatus status;
    private String message;
    List<String> errors;
}
