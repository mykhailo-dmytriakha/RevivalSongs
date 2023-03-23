package org.example.mapper;

import org.example.model.Song;
import org.example.model.dto.SongDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SongMapper {

    @Mapping(target = "id", ignore = true)
    Song toEntity(SongDto dto);

    @Mapping(target = "songId", source = "id")
    SongDto toDto(Song song);
}

