package org.example.model.dto;

public class SongDto {

    private String songId;

    private String title;

    private String lyrics;

    public SongDto(String songId, String title, String lyrics) {
        this.songId = songId;
        this.title = title;
        this.lyrics = lyrics;
    }

    public SongDto() {
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
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
}

