package com.samar.notesapp.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Notes")
public class Note {
    @Id
    private String id;
    private String title;
    private String content;

}
