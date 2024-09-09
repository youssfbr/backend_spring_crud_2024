package com.github.youssfbr.crud.services;

import com.github.youssfbr.crud.entities.Product;
import com.github.youssfbr.crud.entities.RequestProductDTO;
import com.github.youssfbr.crud.entities.ResponseProductDTO;

import java.util.List;

public interface IProductService {

    List<ResponseProductDTO> getAllProducts();

    ResponseProductDTO getProductById(String id);

    Product createProduct(RequestProductDTO data);

}
