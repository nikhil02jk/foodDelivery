//package com.learning.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.learning.entity.Register;
//import com.learning.service.UserService;
//@Controller
//@RestController
//@RequestMapping("/Users")
//public class UserController {
//	
//	@Autowired
//	private UserService userservice;
//	
//	@GetMapping("/allusers")
//	public List<Register> getAllUsers() {
//		return userservice.getUsers();
//	}
//	
//	@GetMapping("/user/{id}")
//	public Optional<Register> getUserByid(@PathVariable int id) {
//		return Optional.empty();
//	}
//
//	@PutMapping("/adduser/{id1}")
//	public Register updateUserByid(@PathVariable int id1) {
//		return userservice.getUserById(id1);
//	}
//	
//	@DeleteMapping("/deleteuser/{id2}")
//	public String DeleteUserByid(@PathVariable int id2) {
//		return userservice.deleteuserbyid(id2);
//	}
//	
//	@PostMapping("/updateUser")
//	public Register postuser(@RequestBody Register user){
//		
//		return userservice.addUser(user);
//		
//	}
//
//
//
//}


package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.learning.entity.Login;
import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.service.LoginService;
import com.learning.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;
	

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody Register register) throws AlreadyExistsException {
		Register result = userService.addUser(register);
		return ResponseEntity.status(201).body(result);
	}
	

	@GetMapping("/alluser")
	public ResponseEntity<?> getAllUser() {
		Optional<List<Register>> optional = userService.getAllUsers();
		if (optional.isEmpty()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "No record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
	}
	
      
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id)
			throws IdNotFoundException {
		Optional<Register> optional = userService.getUserById(id);
		
		return ResponseEntity.ok(optional.get());
	}
	
                           
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Register register)
			throws IdNotFoundException {
		Register result = userService.updateUser(register, id);
		
		return ResponseEntity.status(200).body(result);
	}
	
                             
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") int id)
			throws IdNotFoundException {
		userService.deleteUser(id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "User Deleted Successfully");
		return ResponseEntity.status(200).body(map);
	}

}
