package com.example.springvalidation.transferobjects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TestTO(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotNull String address,
        Integer age
    ) {
    
}
