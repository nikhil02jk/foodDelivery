package com.learning.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.learning.entity.Food;
import com.learning.entity.FoodType;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;

public interface FoodService {
	public Optional<List<Food>> getAllFoods();
	public Optional<Food> getFoodById(int id) throws IdNotFoundException;
	public Food updateFood(Food food, int id) throws IdNotFoundException;
	public String deleteFood(int id) throws IdNotFoundException;
	public Food addFood(@Valid Food food);

}