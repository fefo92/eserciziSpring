package com.example.springboot.service;

import com.example.springboot.dao.IngredientDao;
import com.example.springboot.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService  {
    private IngredientDao ingredientDao;

    @Autowired
    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void addIngredient(Ingredient dumpling) {
        ingredientDao.save(dumpling);
    }

    public void addIngredients(Iterable<Ingredient> ingredients) {
        ingredientDao.saveAll(ingredients);
    }

    public Ingredient getIngredientById(Long id) {
        //contenitore che può sia contenere l'entità che non contenerla
        Optional<Ingredient> optionalIngredient = ingredientDao.findById(id);
        if(optionalIngredient.isPresent()){
            return optionalIngredient.get();
        }
        throw new NullPointerException();

    }

    public Iterable<Ingredient> getAllIngredientById(Iterable<Long> idList) {
        return ingredientDao.findAllById(idList);
    }

    public void removeIngredientById(Long id) {
        ingredientDao.deleteById(id);
    }

    public Ingredient removeAllIngredientsById(Long id){
        Optional<Ingredient> optionalIngredient = ingredientDao.findById(id);
        if(optionalIngredient.isPresent()){
            return optionalIngredient.get();
        }
        throw new NullPointerException();
    }
}
