package com.sprinboot.project.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinboot.project.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Optional<Product> findByprodName(String prodName);
}
