package com.waleed.api.recipesAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @Id
    private ObjectId id;
    private String title;
    private String body;

    public Comments(String body, String title) {
        this.body = body;
        this.title = title;
    }
}
