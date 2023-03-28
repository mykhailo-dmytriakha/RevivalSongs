package org.example.controller;

import org.example.mapper.SongBookMapper;
import org.example.model.SongBook;
import org.example.model.dto.SongBookDto;
import org.example.repo.SongBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/songbooks")
public class SongBookController {

    private static final String NOT_FOUND_MESSAGE = "Song book not found";

    private final SongBookRepository songBookRepository;
    private final SongBookMapper songBookMapper;

    @Autowired
    public SongBookController(SongBookRepository songBookRepository, SongBookMapper songBookMapper) {
        this.songBookRepository = songBookRepository;
        this.songBookMapper = songBookMapper;
    }

    @GetMapping
    public ResponseEntity<List<SongBookDto>> getAllSongBooks() {
        List<SongBookDto> songBookDtos = songBookRepository.findAll().stream()
                .map(songBookMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(songBookDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongBookDto> getSongBookById(@PathVariable String id) {
        SongBook songBook = songBookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE));
        return ResponseEntity.ok(songBookMapper.toDto(songBook));
    }

    @PostMapping
    public ResponseEntity<SongBookDto> createSongBook(@Valid @RequestBody SongBookDto songBookDto) {
        SongBook songBook = songBookRepository.save(songBookMapper.toEntity(songBookDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(songBookMapper.toDto(songBook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongBookDto> updateSongBook(@PathVariable String id, @Valid @RequestBody SongBookDto updatedSongBookDto) {
        SongBook songBook = songBookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE));
        songBook.setTitle(updatedSongBookDto.getTitle());
        songBook = songBookRepository.save(songBook);
        return ResponseEntity.ok(songBookMapper.toDto(songBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSongBook(@PathVariable String id) {
        SongBook songBook = songBookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE));
        songBookRepository.delete(songBook);
        return ResponseEntity.noContent().build();
    }
}
