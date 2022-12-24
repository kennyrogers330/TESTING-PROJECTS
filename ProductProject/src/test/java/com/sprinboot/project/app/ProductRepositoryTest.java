package com.sprinboot.project.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sprinboot.project.app.model.Product;
import com.sprinboot.project.app.repository.ProductRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void SaveTest() {
		Product pr = new Product();
		pr.setProdName("RICE");
		pr.setBrand("rice");
		pr.setPrice(23.5);
		Product prd = productRepository.save(pr);
		assertNotNull(prd);
		assertThat(prd.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void GetAllTest() {
		List<Product> list = productRepository.findAll();
		for(Product prods : list) {
			System.out.println(prods);
		}
		assertNotNull(list);
		assertThat(list).size().isGreaterThan(0);
	}
	@Test 
	@Order(3)
	public void GetProdById() {
		Product prod = productRepository.findById(1L).get();
		assertNotNull(prod);
		assertEquals(prod.getId(), 1L);
		
	}
	@Test 
	@Order(4)
	public void getByName() {
		Product product = productRepository.findByprodName("RICE").get();
		assertThat(product.getProdName()).isEqualTo("RICE");
	}
}
