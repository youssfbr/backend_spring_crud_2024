package com.github.youssfbr.crud.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResponseProductDTO(

        @NotNull String id ,
        @NotBlank String name ,
        @NotNull double price

) {

    public ResponseProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice());
    }
}


