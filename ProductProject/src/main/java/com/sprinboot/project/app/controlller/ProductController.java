package com.sprinboot.project.app.controlller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprinboot.project.app.model.Product;
import com.sprinboot.project.app.service.impl.ProductServiceImplementation;

@RestController
@RequestMapping("/product/api")
public class ProductController {
	
	ProductServiceImplementation productServiceImplementation;
	

	public ProductController(ProductServiceImplementation productServiceImplementation) {
		super();
		this.productServiceImplementation = productServiceImplementation;
	}


	@PostMapping
	public ResponseEntity<Product> addNewProduct(@RequestBody Product pr) {
		return new ResponseEntity<Product>(productServiceImplementation.addProduct(pr), HttpStatus.CREATED);
	}
	@GetMapping
	public List<Product> getAllEmployees(){
		return productServiceImplementation.getAllProducts();
	}
	@GetMapping("{id}")
	public ResponseEntity<Product> getEmpById(@PathVariable("id") Long Id){
		return new ResponseEntity<Product>(productServiceImplementation.getProductById(Id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProductEntity(@RequestBody Product pr, @PathVariable("id") Long Id){
		return new ResponseEntity<Product>(productServiceImplementation.updateProduct(pr, Id), HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProd(@PathVariable("id") Long id){
		return new ResponseEntity<String>("Product Deleted successfully", HttpStatus.OK);
	}
	@GetMapping("{prodName}")
	public ResponseEntity<Product> getProdByNameEntity(@PathVariable("prodName") String productName){
		return new ResponseEntity<Product>(productServiceImplementation.findByProductName(productName), HttpStatus.OK);
	}
}
