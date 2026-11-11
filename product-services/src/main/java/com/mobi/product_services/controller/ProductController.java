package com.mobi.product_services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobi.product_services.entity.Product;
import com.mobi.product_services.repo.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductByID(@PathVariable Long productId){
		Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with ID: "+ productId));
		return ResponseEntity.ok(product);
	}

}
