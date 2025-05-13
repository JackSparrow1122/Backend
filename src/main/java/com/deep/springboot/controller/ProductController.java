package com.deep.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deep.springboot.entity.Product;
import com.deep.springboot.service.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	
	@PostMapping(path = "/products")
	protected Product addProduct(@RequestBody Product product, @RequestParam int userId) {
	return	productServices.addProduct(product,userId);
	}
	
	@GetMapping(path = "/products")
	protected List<Product> findAllProducts() {
	return productServices.findAllProducts();
	}
	
	@PutMapping (path = "/products")
	protected Product Update(@RequestBody Product product) {
		return productServices.update(product);
	}
	
	@DeleteMapping (path ="/products")
	protected String delete(@RequestParam int id) {
		 Product deleteProduct = productServices.deleteProduct(id);
		 if(deleteProduct != null)
			 return "Product is deleted";
		 else
			 return "Invalid Product Id";
	}
	
	@PostMapping (path = "/products/{price}")
	protected List<Product> findByPrice(@PathVariable double price) {
		return productServices.findByPrice(price);
	}
}
