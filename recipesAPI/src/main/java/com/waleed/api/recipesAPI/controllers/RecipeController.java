package com.waleed.api.recipesAPI.controllers;

import com.waleed.api.recipesAPI.models.Recipes;
import com.waleed.api.recipesAPI.service.RecipeService;
import org.bson.types.ObjectId;
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

    @GetMapping
    public ResponseEntity<List<Recipes>> allRecipes(){
        return new ResponseEntity<List<Recipes>>(recipeService.allRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Optional<Recipes>> getRecipeById(@PathVariable String recipeId){
        return new ResponseEntity<Optional<Recipes>>(recipeService.recipeById(recipeId), HttpStatus.OK);
    }

}
