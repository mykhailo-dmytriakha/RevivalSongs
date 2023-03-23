package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "song_books")
public class SongBook {
    public SongBook() {
    }

    public SongBook(String id, String title, List<Song> songs) {
        this.id = id;
        this.title = title;
        this.songs = songs;
    }

    public SongBook(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
    }

    @Id
    private String id;

    @NotBlank
    private String title;

    @DBRef
    private List<Song> songs;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // constructors, getters and setters, other methods
}
