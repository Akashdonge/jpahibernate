package com.coding.jpahibernate.jpahibernate.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class employeerolevalidator implements ConstraintValidator<emproleValidator,String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles=List.of("admin","user");
        return roles.contains(inputRole);
    }
}
