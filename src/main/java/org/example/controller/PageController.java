package org.example.controller;

import org.example.model.SongBook;
import org.example.repo.SongBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;


@Controller
public class PageController {
    private static final String NOT_FOUND_MESSAGE = "Song book not found";
    @Autowired
    private SongBookRepository songBookRepository;

    @GetMapping("/songbooks")
    public String songbooks() {
        return "songbooks";
    }

    @GetMapping("/songbooks/{id}/edit")
    public String editSongbook(@PathVariable("id") String id, Model model) {
        SongBook songBook = songBookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE));
        model.addAttribute("songbook", songBook);

        return "edit-songbook";
    }
}
