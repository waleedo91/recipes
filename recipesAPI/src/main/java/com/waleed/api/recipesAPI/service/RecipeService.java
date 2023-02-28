package com.waleed.api.recipesAPI.service;

import com.waleed.api.recipesAPI.models.Recipes;
import com.waleed.api.recipesAPI.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipes> allRecipes(){
        return recipeRepository.findAll();
    }

    public Recipes recipeById(String recipeId){
        return recipeRepository.findRecipeByRecipeId(recipeId);
    }

    public void deleteById(String recipeId) {
        Recipes recipe = recipeRepository.findRecipeByRecipeId(recipeId);
        recipeRepository.delete(recipe);
    }

}
