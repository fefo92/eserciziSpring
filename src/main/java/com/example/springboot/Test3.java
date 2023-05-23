package com.example.springboot;

import com.example.springboot.model.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Test3 {
    private final List<Meal> listaDiPiatti = Arrays.asList(
            new Meal("LasagneBolognese", "Pasta sfoglia alternata con ragù e besciamella", 10, false),
            new Meal("SpaghettiAllaCarbonara", "Spaghetti con crema di tuorlo d'uovo, pecorino e guanciale", 8, false),
            new Meal("BisteccaAllaFiorentina", "", 35, true)
    );
    @GetMapping("/meals")
    public List<Meal> getMeal() {
        return listaDiPiatti;
    }
    @GetMapping("/meal/{name}")
    public Meal getMealByName(@PathVariable("name") String name) {
        for (Meal meal : listaDiPiatti) {
            if (meal.getName().equals(name)){
                return meal;
            }
        }
        return null;
    }

    @GetMapping("/meal/description-match/{phrase}")
    public Meal getMealByDesc(@PathVariable("phrase") String description) {
        for (Meal meal : listaDiPiatti){
            if (meal.getDescription().equalsIgnoreCase(description)){
                return meal;
            }
        }
        return null;
    }

    @GetMapping("/meal/price/")
    public List<Meal> getMealByPriceRange(@RequestParam("min") double minPrice, @RequestParam("max") double maxPrice) {
        List<Meal> listaPiattiRange = new ArrayList<>();
        for (Meal meal : listaDiPiatti){
            if (meal.getPrice()>= minPrice && meal.getPrice() < maxPrice){
                listaPiattiRange.add(meal);
            }
        }
        return listaPiattiRange;
    }
}
