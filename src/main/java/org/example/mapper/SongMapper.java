package org.example.mapper;

import org.example.model.Song;
import org.example.model.dto.SongDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SongMapper {

    public Song toEntity(SongDto songDto) {
        return new Song(songDto.getSongId(), songDto.getTitle(), songDto.getLyrics());
    }

    public SongDto toDto(Song song) {
        return new SongDto(song.getId(), song.getTitle(), song.getLyrics());
    }

    public List<Song> toEntity(List<SongDto> songs) {
        return songs.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<SongDto> toDto(List<Song> songs) {
        return songs.stream().map(this::toDto).collect(Collectors.toList());
    }
}

