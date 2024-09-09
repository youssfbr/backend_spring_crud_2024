package com.github.youssfbr.crud.repositories;

import com.github.youssfbr.crud.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product , String> {
}
