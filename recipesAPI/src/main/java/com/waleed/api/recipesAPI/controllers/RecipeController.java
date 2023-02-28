package com.waleed.api.recipesAPI.controllers;

import com.waleed.api.recipesAPI.models.Recipes;
import com.waleed.api.recipesAPI.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public ResponseEntity<Recipes> createRecipe(@RequestBody Recipes recipes){
        Recipes createRecipe = recipeService.createRecipe(recipes);
        return new ResponseEntity<Recipes>(recipeService.createRecipe(recipes), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Recipes>> allRecipes(){
        return new ResponseEntity<List<Recipes>>(recipeService.allRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipes> getRecipeById(@PathVariable String recipeId){
        return new ResponseEntity<Recipes>(recipeService.recipeById(recipeId), HttpStatus.OK);
    }


    @DeleteMapping("/{recipeId}")
    public ResponseEntity<String> deleteRecipe(@PathVariable String recipeId){
        recipeService.deleteById(recipeId);
        return new ResponseEntity<>("Recipe has been deleted", HttpStatus.OK);
    }

}
