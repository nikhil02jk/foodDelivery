package com.learning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Register;
import com.learning.service.UserService;
@Controller
@RestController
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/allusers")
	public List<Register> getAllUsers() {
		return userservice.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public Optional<Register> getUserByid(@PathVariable int id) {
		return Optional.empty();
	}

	@PutMapping("/adduser/{id1}")
	public Register updateUserByid(@PathVariable int id1) {
		return userservice.getUserById(id1);
	}
	
	@DeleteMapping("/deleteuser/{id2}")
	public String DeleteUserByid(@PathVariable int id2) {
		return userservice.deleteuserbyid(id2);
	}
	
	@PostMapping("/updateUser")
	public Register postuser(@RequestBody Register user){
		
		return userservice.addUser(user);
		
	}



}
