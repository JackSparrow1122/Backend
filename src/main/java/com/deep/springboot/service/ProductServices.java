package com.deep.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.springboot.entity.Product;
import com.deep.springboot.entity.User;
import com.deep.springboot.repository.ProductRepository;
import com.deep.springboot.repository.UserRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Product addProduct(Product product,int userId) {
	Product addproduct = productRepository.save(product);
	User user = userRepository.findById(userId).get();
	List<Product> products = user.getProducts();
	products.add(addproduct);
	userRepository.save(user);
	return addproduct;
	}

	public List<Product> findAllProducts() {
	return productRepository.findAll();
	}

	public Product update(Product product) {
	return	productRepository.save(product);
	}

	public Product deleteProduct(int id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.delete(product.get());
			return product.get();
		}
		return null;
	}


	public List<Product> findByPrice(double price) {
		return productRepository.findByPrice(price);
	}

}
