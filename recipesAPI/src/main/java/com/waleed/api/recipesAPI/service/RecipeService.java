package com.waleed.api.recipesAPI.service;

import com.waleed.api.recipesAPI.models.Recipes;
import com.waleed.api.recipesAPI.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;


    // POST RECIPE
    public Recipes createRecipe(Recipes recipes){
        return recipeRepository.save(recipes);
    }


    // GET ALL RECIPES
    public List<Recipes> allRecipes(){
        return recipeRepository.findAll();
    }

    // GET RECIPE BY ID
    public Recipes getRecipeById(String recipeId){
        return recipeRepository.findById(recipeId)
                .orElseThrow(
                        () -> new RuntimeException(
                                String.format("Recipe not found with ID: %s", recipeId)));
    }


    // UPDATE RECIPE
    public void updateRecipe(String recipeId){
        Recipes recipe = recipeRepository.findById(recipeId)
                .orElseThrow(
                        () -> new RuntimeException(
                                String.format("Recipe not found with ID: %s", recipeId)));

        recipe.setRecipeName(recipe.getRecipeName());
        recipe.setRecipeImage(recipe.getRecipeImage());
        recipe.setCookTime(recipe.getCookTime());
        recipe.setPrepTime(recipe.getPrepTime());
        recipe.setIngredients(recipe.getIngredients());

        recipeRepository.save(recipe);
    }


    // DELETE RECIPE
    public void deleteRecipeById(String recipeId) {
        Recipes recipe = recipeRepository.findById(recipeId)
                .orElseThrow(
                        () -> new RuntimeException(
                                String.format("Could not find Comment with ID %s", recipeId)));

        recipeRepository.delete(recipe);
    }
}
