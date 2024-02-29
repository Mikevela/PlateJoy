package com.example.food.platejoy;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> allRecipes() {
        return recipeRepository.findAll();
    }

//    public Optional<Recipe> singleRecipe(ObjectId id) {
//        return recipeRepository.findById(id);
//    }

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(ObjectId id) {
        recipeRepository.deleteById(id);
    }

    public Recipe getRecipeById(ObjectId id) {
        return recipeRepository.findById(id).orElse(null);
    }
}
