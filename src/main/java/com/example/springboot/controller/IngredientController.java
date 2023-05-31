package com.example.springboot.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.model.Meal;
import com.example.springboot.service.IngredientService;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class IngredientController {
    private IngredientService ingredientService;
    private MealService mealService;

    @Autowired
    public IngredientController(IngredientService ingredientService, MealService mealService) {
        this.ingredientService = ingredientService;
        this.mealService = mealService;
    }

    @PostMapping("/add-ingredient")
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);

        return ResponseEntity.ok("Ingrediente creato");

    }
    @GetMapping("/get-ingredient/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id){
        ingredientService.getIngredientById(id);

        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete-ingredient/{id}")
    public ResponseEntity<String> deleteIngredientById(@PathVariable Long id){
        ingredientService.removeIngredientById(id);

        return ResponseEntity.ok("Ingrediente rimosso");
    }
    @PutMapping("/put-ingredient/{id}")
    public ResponseEntity<String> modifyIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient){
        ingredientService.removeIngredientById(id);
        ingredientService.addIngredient(ingredient);

        return ResponseEntity.ok("Ingrediente modificato");

    }
}

//CONTROLLER oggetti che ricevono le api e le elaborano, parlano con il frontend. Posso implementare degli endpoint e
//delle operazioni crud ma non hanno logica al loro interno (come specie un interfaccia), è associato 1 per ogni entità

//la logica dei metodi sta nel SERVICE, ma non per tutte le entità, solo per quelle che hanno bisogno di delle funzionalità.
//un service può essere utilizzato da più controllers

//@repository sono interfacce che contengono una serie di metodi crud per gestire il DB(crea automaticamente lo script sql)