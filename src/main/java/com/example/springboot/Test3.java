package com.example.springboot;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Test3 {
    private List<Meal> listaDiPiatti = new ArrayList<>();

    //TASK 3
    // esercizio 1
    @GetMapping("get/meals")
    public List<Meal> getMeal() {
        return listaDiPiatti;
    }
    // esercizio 2
    @GetMapping("get/meal/{name}")
    public Meal getMealByName(@PathVariable("name") String name) {
        for (Meal meal : listaDiPiatti) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null;
    }
    //esercizio 3
    @GetMapping("get/meal/description-match/{phrase}")
    public Meal getMealByDesc(@PathVariable("phrase") String description) {
        for (Meal meal : listaDiPiatti) {
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
        for (Meal meal : listaDiPiatti) {
            if (meal.getPrice() >= minPrice && meal.getPrice() < maxPrice) {
                listaPiattiRange.add(meal);
            }
        }
        return listaPiattiRange;
    }

    //TASK 4
    //esercizio 1
    @PutMapping("put/meal")
    public String putMeal(@RequestBody Meal meal) {
        this.listaDiPiatti.add(meal);
        return "Piatto aggiunto";
    }
    //esercizio 2
    @PostMapping("/post/meal/{name}")
    public String modifyMealByName(@PathVariable("name") String name, @RequestBody Meal updatedMeal) {
        for (Meal meal : listaDiPiatti) {
            if (meal.getName().equals(name)) {
                meal.setName(updatedMeal.getName());
                meal.setDescription(updatedMeal.getDescription());
                meal.setIngredients(updatedMeal.getIngredients());
                return "Piatto modificato";
            }
        }
        return null;
    }
    //esercizio 3
    @DeleteMapping("delete/meal/{name}")
    public String deleteMeal(@PathVariable("name") String name) {
        this.listaDiPiatti.removeIf(meal -> meal.getName().equals(name));
        return "Piatto cancellato";
    }
    //esercizio 4
    @DeleteMapping("delete/meal/price/{price}")
    public String deleteMealAbovePrice(@PathVariable("price") double price) {
        listaDiPiatti.removeIf(meal -> meal.getPrice() > price);
        return "Piatti che superano il prezzo stabilito cancellati";
    }
    //esercizio 5
    @PutMapping("put/meal/{name}/price")
    public String putPriceByName(@PathVariable("name") String name, @RequestBody Meal updatedPrice) {
        for (Meal meal : listaDiPiatti) {
            if (meal.getName().equals(name)) {
                meal.setPrice(updatedPrice.getPrice());
                return "Piatto modificato";
            }
        }
        return null;
    }


}
