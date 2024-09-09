package com.github.youssfbr.crud.controllers.exceptions;

import java.time.Instant;

public record StandardErrorDTO(

        Instant timestamp ,
        Integer status ,
        String error ,
        String message ,
        String path
){
}
