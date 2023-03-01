package com.waleed.api.recipesAPI.controllers;

import com.waleed.api.recipesAPI.models.Recipes;
import com.waleed.api.recipesAPI.repository.RecipeRepository;
import com.waleed.api.recipesAPI.service.RecipeService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping
    public ResponseEntity<Recipes> createRecipe(@RequestBody Recipes recipes){
        Recipes createRecipe = recipeService.createRecipe(recipes);
        return new ResponseEntity<Recipes>(recipeService.createRecipe(recipes), HttpStatus.CREATED);
    }

    @PutMapping("/{recipeId}")
    public ResponseEntity<Recipes> updateRecipe(@RequestBody Recipes recipe,
                                                @PathVariable("recipeId") String recipeId){

        recipeService.updateRecipe(recipeId);
        return new ResponseEntity<Recipes>(recipe, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Recipes>> allRecipes(){
        return new ResponseEntity<List<Recipes>>(recipeService.allRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipes> getRecipeById(@PathVariable String recipeId){
        return ResponseEntity.ok(recipeService.getRecipeById(recipeId));
    }


    @DeleteMapping("/{recipeId}")
    public ResponseEntity<String> deleteRecipe(@PathVariable String recipeId){
        recipeService.deleteRecipeById(recipeId);
        return new ResponseEntity<>("Recipe has been deleted", HttpStatus.OK);
    }

}
