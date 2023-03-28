package org.example.model.dto;

import java.util.Collections;
import java.util.List;

public class SongBookDto {

    private String id;

    private String title;

    private List<SongDto> songs;

    public SongBookDto(String id, String title, List<SongDto> songs) {
        this.id = id;
        this.title = title;
        this.songs = songs;
    }

    public SongBookDto() {
    }

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

    public List<SongDto> getSongs() {
        if (songs == null) return Collections.emptyList();
        return songs;
    }

    public void setSongs(List<SongDto> songs) {
        this.songs = songs;
    }
}

