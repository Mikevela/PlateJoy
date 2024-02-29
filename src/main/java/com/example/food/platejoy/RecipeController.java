package com.example.food.platejoy;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<List<Recipe>>(recipeService.allRecipes(), HttpStatus.OK);
    }

    @GetMapping("/secured")
    public String secured() {
        return "Secured!";
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Recipe>> getSingleRecipe(@PathVariable ObjectId id) {
//        return new ResponseEntity<Optional<Recipe>>(recipeService.singleRecipe(id), HttpStatus.OK);
//    }

    @PostMapping
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable ObjectId id, @RequestBody Recipe recipe) {
        Recipe existingRecipe = recipeService.getRecipeById(id);

        if(existingRecipe != null) {
            existingRecipe.setName(recipe.getName());
            existingRecipe.setIngredients(recipe.getIngredients());
            existingRecipe.setCuisine(recipe.getCuisine());
            existingRecipe.setCourse(recipe.getCourse());
            existingRecipe.setInstructions(recipe.getInstructions());

            return recipeService.saveRecipe(existingRecipe);
        }else {
            //handle the case where the recipe with the given id is not found
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable ObjectId id) {
        recipeService.deleteRecipe(id);
    }
}
