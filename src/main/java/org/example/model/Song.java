package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "songs")
public class Song {
    @Id
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String lyrics;

    @DBRef
    private SongBook songBook;

    // constructors, getters and setters, other methods
}


