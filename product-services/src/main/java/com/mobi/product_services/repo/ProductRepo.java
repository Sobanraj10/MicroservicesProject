package com.mobi.product_services.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobi.product_services.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
