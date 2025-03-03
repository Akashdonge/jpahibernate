package com.coding.jpahibernate.jpahibernate.dto;

import com.coding.jpahibernate.jpahibernate.annotations.isprime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class departmentDto {
    Long id;
    @NotNull(message = "title should not be null")
    @NotBlank(message = "title should not be blank")
     @Size(min = 3, max = 100, message = "title should be between 3 and 20")
     String title;
      @Email(message = "email should be valid")
      String depEmail;


      @JsonProperty("isActive")
      Boolean isActive;
      @Max(value = 100, message = "noOfEmp should be less than 100")
      @Min(value = 10, message = "noOfEmp should be greater than 10")
      @isprime
      Integer noOfEmp;
      @Min(value = 10, message = "avgSal should be greater than 10000")
      Double avgSal;
      LocalDateTime createdAt;


}
