package com.example.springboot.service;

import com.example.springboot.dao.AnotherMealDao;
import com.example.springboot.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotherMealService {
    private AnotherMealDao anotherMealDao;

    @Autowired
    public AnotherMealService(AnotherMealDao anotherMealDao) {
        this.anotherMealDao = anotherMealDao;
    }
    public void addMeal(Meal meal){
        if (meal == null) throw new IllegalArgumentException("Meal must not be null");
        if (meal.getName() == null || meal.getName().isEmpty()) throw new IllegalArgumentException("Meal name must not be empty");
        if (meal.getDescription() == null || meal.getDescription().isEmpty()) throw new IllegalArgumentException("Meal description must not be empty");
        if (meal.getPrice() < 0) throw new IllegalArgumentException("Meal price must be over zero");
        anotherMealDao.addMeal(meal);
    }
    public void deteleMeal(String mealName){
        anotherMealDao.deleteMeal(mealName);
    }

    public void updateMeal(Meal meal){
        anotherMealDao.updateMeal(meal);
    }

    public List<Meal> getMeals(){
        return anotherMealDao.getMeals();
    }
}
