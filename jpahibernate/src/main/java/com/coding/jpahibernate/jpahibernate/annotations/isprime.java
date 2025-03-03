package com.coding.jpahibernate.jpahibernate.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = isprimevalidator.class)
public @interface isprime {
    String message() default "Role user may be admin or user";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
