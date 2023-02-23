package com.waleed.api.recipesAPI.service;

import com.waleed.api.recipesAPI.models.Comments;
import com.waleed.api.recipesAPI.models.Recipes;
import com.waleed.api.recipesAPI.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Comments postComment(String commentTitle, String commentBody, String recipeId){

        Comments comment = commentRepository.insert(new Comments(commentTitle, commentBody));
        mongoTemplate.update(Recipes.class)
                .matching(Criteria.where("recipeId").is(recipeId))
                .apply(new Update().push("comments").value(comment))
                .first();

        return comment;
    }
}
