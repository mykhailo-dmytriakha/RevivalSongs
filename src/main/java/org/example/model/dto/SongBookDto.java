package org.example.model.dto;

import java.util.List;

public class SongBookDto {

    private String songBookId;

    private String title;

    private List<SongDto> songs;

    public SongBookDto(String songBookId, String title, List<SongDto> songs) {
        this.songBookId = songBookId;
        this.title = title;
        this.songs = songs;
    }

    public SongBookDto() {
    }

    public String getSongBookId() {
        return songBookId;
    }

    public void setSongBookId(String songBookId) {
        this.songBookId = songBookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SongDto> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDto> songs) {
        this.songs = songs;
    }
}

