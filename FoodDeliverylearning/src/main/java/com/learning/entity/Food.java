package com.learning.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Food {
	
//	   @Id //Id must be auto generated 
//	   
//	   private int foodId;
//	   @NotBlank
//	   private String foodName; 
//	   @NotNull
//	   private int foodCost; 
	@Id
	
	private String foodId;
	
	
	@Size(max=50)
	@NotBlank
	private String foodName;
	
	
	private String description;
	private String foodPic;

	
	
	@ManyToMany
	@JoinTable(name = "food_foodtypes", joinColumns = @JoinColumn(name = "foodId"), 
			inverseJoinColumns = @JoinColumn(name = "foodTypeId"))
	private Set<FoodType> foodTypes = new HashSet<>();
	


}
