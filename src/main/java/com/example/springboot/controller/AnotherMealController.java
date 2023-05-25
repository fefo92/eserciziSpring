package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnotherMealController {
    private MealService mealService;
    @Autowired
    public AnotherMealController(MealService mealService) {
        this.mealService = mealService;
    }

    //TASK 3
    // esercizio 1
    @GetMapping("get/meals")
    public List<Meal> getMeal() {
        return mealService.getMeals();
    }
    // esercizio 2
    @GetMapping("get/meal/{name}")
    public Meal getMealByName(@PathVariable("name") String name) {
        for (Meal meal : mealService.getMeals()) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null;
    }
    //esercizio 3
    @GetMapping("get/meal/description-match/{phrase}")
    public Meal getMealByDesc(@PathVariable("phrase") String description) {
        for (Meal meal : mealService.getMeals()) {
            if (meal.getDescription().equalsIgnoreCase(description)) {
                return meal;
            }
        }
        return null;
    }
    //esercizio 4
    @GetMapping("get/meal/price/")
    public List<Meal> getMealByPriceRange(@RequestParam("min") double minPrice, @RequestParam("max") double maxPrice) {
        List<Meal> listaPiattiRange = new ArrayList<>();
        for (Meal meal : mealService.getMeals()) {
            if (meal.getPrice() >= minPrice && meal.getPrice() < maxPrice) {
                listaPiattiRange.add(meal);
            }
        }
        return listaPiattiRange;
    }

    //TASK 4
    //esercizio 1
    @PutMapping("put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal) {
        try {
            this.mealService.addMeal(meal);
            return ResponseEntity.ok("Piatto aggiunto");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //esercizio 2
    @PostMapping("/post/meal/{name}")
    public ResponseEntity<String> modifyMealByName(@PathVariable("name") String name, @RequestBody Meal updatedMeal) {
        for (Meal meal : mealService.getMeals()) {
            if (meal.getName().equals(name)) {
                meal.setName(updatedMeal.getName());
                meal.setDescription(updatedMeal.getDescription());
                meal.setIngredients(updatedMeal.getIngredients());
                return ResponseEntity.ok("Piatto modificato");
            }
        }
        return ResponseEntity.badRequest().body("Errore!");
    }
    //esercizio 3
    @DeleteMapping("delete/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable("name") String name) {
        this.mealService.getMeals().removeIf(meal -> meal.getName().equals(name));
        return ResponseEntity.ok("Piatto eliminato");
    }
    //esercizio 4
    @DeleteMapping("delete/meal/price/{price}")
    public ResponseEntity<String> deleteMealAbovePrice(@PathVariable("price") double price) {
        mealService.getMeals().removeIf(meal -> meal.getPrice() > price);
        return ResponseEntity.ok("Piatti che superano il prezzo stabilito eliminati");
    }
    //esercizio 5
    @PutMapping("put/meal/{name}/price")
    public ResponseEntity<String> putPriceByName(@PathVariable("name") String name, @RequestBody Meal updatedPrice) {
        for (Meal meal : mealService.getMeals()) {
            if (meal.getName().equals(name)) {
                meal.setPrice(updatedPrice.getPrice());
                return ResponseEntity.ok("Piatto modificato");
            }
        }
        return ResponseEntity.badRequest().body("Errore!");
    }


}
