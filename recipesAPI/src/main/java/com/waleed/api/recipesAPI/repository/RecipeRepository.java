package com.waleed.api.recipesAPI.repository;

import com.waleed.api.recipesAPI.models.Recipes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipes, String> {
}
