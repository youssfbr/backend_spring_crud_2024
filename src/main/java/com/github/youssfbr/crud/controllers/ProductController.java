package com.github.youssfbr.crud.controllers;

import com.github.youssfbr.crud.entities.RequestProductDTO;
import com.github.youssfbr.crud.entities.ResponseProductDTO;
import com.github.youssfbr.crud.services.IProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> getAllProducts(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseProductDTO> registerProduct(@RequestBody @Valid RequestProductDTO data) {

        final ResponseProductDTO productCreated = productService.createProduct(data);

        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productCreated.id()).toUri();

        return ResponseEntity.created(uri).body(productCreated);
    }

}
