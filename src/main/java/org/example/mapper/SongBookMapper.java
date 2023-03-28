package org.example.mapper;

import org.example.model.SongBook;
import org.example.model.dto.SongBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SongBookMapper {
    @Autowired
    private SongMapper songMapper;

    public SongBook toEntity(SongBookDto songBookDto) {
        return new SongBook(
                songBookDto.getId(),
                songBookDto.getTitle(),
                songMapper.toEntity(songBookDto.getSongs())
        );
    }

    public SongBookDto toDto(SongBook songBook) {
        return new SongBookDto(songBook.getId(), songBook.getTitle(), songMapper.toDto(songBook.getSongs()));
    }

    public List<SongBookDto> toDto(List<SongBook> songBooks) {
        return songBooks.stream().map(this::toDto).collect(Collectors.toList());
    }

}

