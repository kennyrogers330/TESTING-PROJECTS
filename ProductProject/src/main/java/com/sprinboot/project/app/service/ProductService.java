package com.sprinboot.project.app.service;

import java.util.List;



import com.sprinboot.project.app.model.Product;

public interface ProductService {
	Product addProduct(Product prod);
	List<Product> getAllProducts();
	Product getProductById(Long id);
	Product updateProduct(Product prod, Long id);
	void deleteProduct(Long id);
	Product findByProductName(String prodName);
}
