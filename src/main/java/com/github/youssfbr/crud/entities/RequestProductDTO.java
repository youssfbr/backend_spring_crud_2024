package com.github.youssfbr.crud.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProductDTO(

        @NotBlank String name ,
        @NotNull double price) {
}
