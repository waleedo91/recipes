package com.waleed.api.recipesAPI.repository;

import com.waleed.api.recipesAPI.models.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comments, String> {
}
