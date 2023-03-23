package org.example.mapper;

import org.example.model.SongBook;
import org.example.model.dto.SongBookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {SongMapper.class})
public interface SongBookMapper {

    @Mapping(target = "id", ignore = true)
    SongBook toEntity(SongBookDto songBookDto);

    @Mapping(target = "id", source = "_id")
    SongBookDto toDto(SongBook songBook);

    List<SongBookDto> toDto(List<SongBook> songBooks);

}

