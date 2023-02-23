package com.waleed.api.recipesAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
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
    private ObjectId id;
    private String recipeId;
    private String recipeName;
    private String recipeImage;
    private int cookTime;
    private int prepTime;
    private List<String> ingredients;

    @DocumentReference
    private List<Comments> comments;

}
