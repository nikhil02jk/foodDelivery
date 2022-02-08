package com.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Food;
import com.learning.entity.FoodType;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

	List<Food> findAllByFoodType(FoodType foodType);

}
