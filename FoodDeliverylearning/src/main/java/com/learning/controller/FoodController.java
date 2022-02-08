//package com.learning.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.learning.entity.Food;
//import com.learning.service.FoodService;
//
//
//@RestController
//@RequestMapping("/foods")
//public class FoodController {
//	
//	@Autowired
//	private FoodService foodservice;
//	@PostMapping("/addfood")
//	public Food addFood(@RequestBody Food food)
//	{
//	return foodservice.saveFood(food);
//	}
//	@GetMapping("food/{foodId}")
//	public Food findFoodById(@PathVariable int foodId)
//	{
//		return foodservice.getFoodById(foodId);
//	}
//	//@PutMapping("/api/food/:foodId")
//	//public String updateFood(@PathVariable foodId, @RequestBody Food food)
//	//{
////		return service.updateFood(foodId, food)
//	//}
//	@GetMapping("allfoods/")
//	public List<Food> findAllFoods()
//	{
//		return foodservice.getFood();
//	}
//	//@GetMapping("/api/food/{foodType}")
//	@DeleteMapping("/deletefood/{foodId}")
//	public String deleteFood(@PathVariable int foodId)
//	{
//		return foodservice.deleteFood(foodId);
//	}
//
//}


package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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

import com.learning.entity.Food;
import com.learning.entity.FoodType;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@PostMapping("/addFood")
	public ResponseEntity<?> addFood(@Valid @RequestBody Food food)
			throws AlreadyExistsException {
		Food result = foodService.addFood(food);
		return ResponseEntity.status(201).body(result);}
	
	                    /// get the food by id
	@GetMapping("food/{foodId}")
	public ResponseEntity<?> getFoodById(@PathVariable("id") int id)
			throws IdNotFoundException {
		Optional<Food> optional = foodService.getFoodById(id);
		return ResponseEntity.ok(optional.get());
	}
	
              //get all the food
	
	@GetMapping("/allfoods")
	public ResponseEntity<?> getAllFoodDetails(){
		Optional<List<Food>> optional = foodService.getAllFoods();
		if(optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());	
		
	}
	
               //	PUT  for updating food item using id
	@PutMapping("/updatefood/{id}")
	public ResponseEntity<?> updateFood(@PathVariable("id") int id, @RequestBody Food food)
			throws IdNotFoundException {
		Food result = foodService.updateFood(food, id);
		
		return ResponseEntity.status(200).body(result);
	}
	

	
               //	DELETE request for deleting food item by id
	@DeleteMapping("/deletefood/{id}")
	public ResponseEntity<?> deleteFoodById(@PathVariable("id") int id)
			throws IdNotFoundException {
		foodService.deleteFood(id);
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("message", "Food items deleted");
		return ResponseEntity.status(200).body(map);
	}

}
