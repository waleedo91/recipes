package com.waleed.api.recipesAPI.controllers;

import com.waleed.api.recipesAPI.models.Comments;
import com.waleed.api.recipesAPI.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comments> createComment(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Comments>(
                commentService.postComment(
                        payload.get("commentTitle"),
                        payload.get("commentBody"),
                        payload.get("recipeId")),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comments>> allComments() {
        return new ResponseEntity<List<Comments>>(commentService.allComments(), HttpStatus.OK);
    }

}
