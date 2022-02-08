package com.learning.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Food;
import com.learning.entity.FoodType;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repository.FoodRepository;
import com.learning.service.FoodService;
import com.learning.utils.Fileutils;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository foodRepo;
	@Autowired
	private Fileutils fileUtils;
	
	@Override
	public Food addFood(Food food) {
		return null;
	}
	@Override
	public Optional<List<Food>> getAllFoods() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(foodRepo.findAll());
	}

	@Override
	public Optional<Food> getFoodById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Food> optional = foodRepo.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Sorry the Food is  Not Found");
		}
		return optional;
	}

	@Override
	public Food updateFood(Food food, int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (foodRepo.findById(id).isEmpty()) {
			throw new IdNotFoundException("Sorry the Food is  Not Found");
		}
		return foodRepo.save(food);
	}

	@Override
	public String deleteFood(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Food> optional = foodRepo.findById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Sorry the Food  is Not Found");
		else {
			foodRepo.deleteById(id);
			return "Success";
		}
	}



}
