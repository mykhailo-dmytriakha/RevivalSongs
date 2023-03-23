package org.example.mapper;

import org.example.model.Song;
import org.example.model.dto.SongDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SongMapper {

    @Mapping(target = "_id", ignore = true)
    Song toEntity(SongDto dto);

    @Mapping(target = "songId", source = "_id")
    SongDto toDto(Song song);
}

