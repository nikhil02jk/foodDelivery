package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Food;
import com.learning.service.FoodService;


@RestController
@RequestMapping("/foods")
public class FoodController {
	
	@Autowired
	private FoodService foodservice;
	@PostMapping("/addfood")
	public Food addFood(@RequestBody Food food)
	{
	return foodservice.saveFood(food);
	}
	@GetMapping("food/{foodId}")
	public Food findFoodById(@PathVariable int foodId)
	{
		return foodservice.getFoodById(foodId);
	}
	//@PutMapping("/api/food/:foodId")
	//public String updateFood(@PathVariable foodId, @RequestBody Food food)
	//{
//		return service.updateFood(foodId, food)
	//}
	@GetMapping("allfoods/")
	public List<Food> findAllFoods()
	{
		return foodservice.getFood();
	}
	//@GetMapping("/api/food/{foodType}")
	@DeleteMapping("/deletefood/{foodId}")
	public String deleteFood(@PathVariable int foodId)
	{
		return foodservice.deleteFood(foodId);
	}

}
