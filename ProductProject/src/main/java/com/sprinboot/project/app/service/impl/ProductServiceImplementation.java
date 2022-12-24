package com.sprinboot.project.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sprinboot.project.app.model.Product;
import com.sprinboot.project.app.repository.ProductRepository;
import com.sprinboot.project.app.service.ProductService;
@Service
public class ProductServiceImplementation implements ProductService{
	
	ProductRepository productRepo;
	
	public ProductServiceImplementation(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}

	@Override
	public Product addProduct(Product prod) {
		return productRepo.save(prod);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> prod = productRepo.findById(id);
		if(prod.isPresent()) {
			return prod.get();
		}else
			throw new RuntimeException("Product not found");
	}

	@Override
	public Product updateProduct(Product prod, Long id) {
		Product prod1 = productRepo.findById(id).get();
		if(prod1==null) {
			throw new RuntimeException("Product not Found");
		}
		
		prod1.setProdName(prod.getProdName());
		prod1.setBrand(prod.getBrand());
		prod1.setPrice(prod.getPrice());
		productRepo.save(prod1);
		return productRepo.save(prod1);
	}

	@Override
	public void deleteProduct(Long id) {
		Product prod1 = productRepo.findById(id).get();
		if(prod1==null) {
			throw new RuntimeException("Product not Found");
		}
		productRepo.deleteById(id);
	}

	@Override
	public Product findByProductName(String prodName) {
		Product product = productRepo.findByprodName(prodName).get();	
		if(product==null) {
			throw new RuntimeException("Product not Found"); 
		}
		return product;
	}


}
