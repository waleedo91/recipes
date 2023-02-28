package com.waleed.api.recipesAPI.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipes {
    @Id
    private String recipeId;
    @NotNull
    private String recipeName;
    @NotNull
    private String recipeImage;
    @NotNull
    private int cookTime;
    @NotNull
    private int prepTime;
    @NotNull
    private List<String> ingredients;

    @DocumentReference
    private List<Comments> comments;


    public Recipes(String recipeName, String recipeImage, int cookTime, int prepTime, List<String> ingredients) {
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
        this.cookTime = cookTime;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
    }
}
