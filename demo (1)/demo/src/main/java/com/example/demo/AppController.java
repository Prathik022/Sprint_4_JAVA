package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AppController {
	
	User user;
	@GetMapping("{userName}")
	public User getUserDetails(String userName) {
		
		return user;
	}
	
	@PostMapping
	public String createUserDetails(@RequestBody User user) {
		this.user = user;
		return "User Added successfully";
	}
	
	@PutMapping
	public String updateUserDetails(@RequestBody User user) {
		this.user = user;
		return "User details updated successfully";
	}
	
	@DeleteMapping("{userName}")
	public String deleteUserDetails(String userName) {
		this.user = null;
		return "User details deleted successfully";
	}
}
