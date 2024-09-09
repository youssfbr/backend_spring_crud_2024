package com.github.youssfbr.crud.controllers.exceptions;

import com.github.youssfbr.crud.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardErrorDTO> resourceNotFoundException(
            ResourceNotFoundException e , HttpServletRequest request) {

        final int notFound = HttpStatus.NOT_FOUND.value();

        StandardErrorDTO err = new StandardErrorDTO(
                Instant.now(),
                notFound,
                "Resource not found!",
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(notFound).body(err);
    }
}
