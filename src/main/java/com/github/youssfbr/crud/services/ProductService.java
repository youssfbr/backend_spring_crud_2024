package com.github.youssfbr.crud.services;

import com.github.youssfbr.crud.entities.Product;
import com.github.youssfbr.crud.entities.RequestProductDTO;
import com.github.youssfbr.crud.entities.ResponseProductDTO;
import com.github.youssfbr.crud.repositories.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ResponseProductDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseProductDTO getProductById(String id) {
        return productRepository.findById(id)
                .map(ResponseProductDTO::new)
                .orElseThrow();
    }

    @Override
    public Product createProduct(RequestProductDTO data) {
        final Product productToCreate = new Product(data);
        return productRepository.save(productToCreate);
    }

}
