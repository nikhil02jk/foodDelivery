package com.learning.service;

import java.util.List;

import com.learning.entity.Food;
import com.learning.exception.IdNotFoundException;

public interface FoodService {
	public Food saveFood(Food food);
	public List<Food> getFood();
	public List<Food> saveFoods(List<Food> foods);
	public Food getFoodById(int foodId);
	public String updateFood(int foodId, Food food) throws IdNotFoundException, Exception;
	public Food getFoodById(String foodId) throws IdNotFoundException;
	String deleteFood(int foodId);
	

}
