package org.example.controller;

import org.example.model.SongBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SongBookController {
    @GetMapping("/songbooks")
    public List<SongBook> getAllSongBooks() {
        return Collections.singletonList(new SongBook("Revival Song Book"));
    }
}
