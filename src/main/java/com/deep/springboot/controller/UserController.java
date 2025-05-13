package com.deep.springboot.controller;

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
import com.deep.springboot.entity.User;
import com.deep.springboot.service.ProductServices;
import com.deep.springboot.service.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping(path = "/users")
	protected User  addUser(@RequestBody User user) {
		return userServices.addUser(user);
	}
	
	@GetMapping(path = "/msg")
	protected String  addUser() {
		return "Hello World";
	}
	
	@PostMapping(path = "/users/auth")
	protected String authentication(@RequestParam String email,@RequestParam String password) {
		User auth = userServices.auth(email,password);
		if(auth != null)
			return "auth User";
		else
			return "Invalid Password OR Email";
	}
	
	@DeleteMapping(path="/users")
	protected String deleteUser(int id) {
		User deletedUser = userServices.deleteProduct(id);
		if(deletedUser!=null)
			return "user is deleted";
		else
			return "Invalid credentials";
		
	}
	
	@PutMapping(path = "/users")
	protected User updateUser(@RequestBody User user) {
		return userServices.updateUser(user);
	}
	
}