package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "songs")
public class Song {
    public Song(String id, String title, String lyrics) {
        this.id = id;
        this.title = title;
        this.lyrics = lyrics;
    }

    public Song() {
    }

    @Id
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String lyrics;

    @DBRef
    private SongBook songBook;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public SongBook getSongBook() {
        return songBook;
    }

    public void setSongBook(SongBook songBook) {
        this.songBook = songBook;
    }
}


