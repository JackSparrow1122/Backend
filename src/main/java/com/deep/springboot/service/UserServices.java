package com.deep.springboot.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.springboot.entity.Product;
import com.deep.springboot.entity.User;
import com.deep.springboot.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	public User addUser(User user) {
		user.setProducts(new ArrayList<Product>());
		return repository.save(user);
	}

	public User auth(String email, String password) {
		Optional<User> user = repository.findByEmailAndPassword(email, password);
		if(user.isPresent()) {
			if(user.get().getEmail().equals(email) && user.get().getPassword().equals(password)) {
				return user.get();
			}
		}
		return null;
			
	}

	public User deleteProduct(int id) {
		Optional<User> user = repository.findById(id);
		if(user.isPresent())
		{
			repository.delete(user.get());
			return user.get();
		}
		return null;
	}

	public User updateUser(User user) {
		User updateUser = repository.save(user);
		if(updateUser != null)
			return updateUser;
		else
			return null;
	}

	

	
	
	

}
