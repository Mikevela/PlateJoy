package com.example.food.platejoy;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> allRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        System.out.println(recipes);
        return recipes;
//        return recipeRepository.findAll();
    }

    public Optional<Recipe> singleRecipe(ObjectId id) {
        return recipeRepository.findById(id);
    }
}
