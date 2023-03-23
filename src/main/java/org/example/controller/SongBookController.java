package org.example.controller;

import org.example.mapper.SongBookMapper;
import org.example.model.SongBook;
import org.example.model.dto.SongBookDto;
import org.example.repo.SongBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/songbooks")
public class SongBookController {
    private static final String NOT_FOUND_MESSAGE = "Song book not found";

    @Autowired
    private SongBookRepository songBookRepository;

    @Autowired
    private SongBookMapper songBookMapper;

    @GetMapping
    public List<SongBookDto> getAllSongBooks() {
        List<SongBook> songBooks = songBookRepository.findAll();
        return songBookMapper.toDto(songBooks);
    }

    @GetMapping("/{id}")
    public SongBookDto getSongBookById(@PathVariable String id) {
        SongBook songBook = songBookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE));
        return songBookMapper.toDto(songBook);
    }

    @PostMapping
    public SongBookDto createSongBook(@RequestBody SongBookDto songBookDto) {
        SongBook songBook = songBookMapper.toEntity(songBookDto);
        songBook = songBookRepository.save(songBook);
        return songBookMapper.toDto(songBook);
    }

    @PutMapping("/{id}")
    public SongBookDto updateSongBook(@RequestBody SongBookDto updatedSongBookDto, @PathVariable String id) {
        songBookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE));
        SongBook updatedSongBook = songBookMapper.toEntity(updatedSongBookDto);
        updatedSongBook.setId(id);
        return songBookMapper.toDto(songBookRepository.save(updatedSongBook));
    }


    @DeleteMapping("/{id}")
    public void deleteSongBook(@PathVariable String id) {
        SongBook songBook = songBookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE));
        songBookRepository.delete(songBook);
    }
}
