package com.example.springboot.dao;

import com.example.springboot.model.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnotherMealDao {
    private List<Meal> listaDiPiatti = new ArrayList<>();

    public void addMeal(Meal meal){
        this.listaDiPiatti.add(meal);
    }

    public void deleteMeal(String name) {
        this.listaDiPiatti.removeIf(meal -> meal.getName().equals(name));
    }

    public void updateMeal(Meal meal){
        this.listaDiPiatti.removeIf(m -> meal.getName().equals(meal.getName()));
        this.listaDiPiatti.add(meal);
    }

    public List<Meal> getMeals() {
        return this.listaDiPiatti;
    }
}
