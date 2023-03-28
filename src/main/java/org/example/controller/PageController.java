package org.example.controller;

import org.example.mapper.SongBookMapper;
import org.example.model.SongBook;
import org.example.repo.SongBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/page")
@RestController
public class PageController {
    @Autowired
    private SongBookRepository songBookRepository;

    @Autowired
    private SongBookMapper songBookMapper;

    @GetMapping("/songbooks")
    public String getSongBookPage(Model model) {
        List<SongBook> songBooks = songBookRepository.findAll();
        model.addAttribute("songBooks", songBookMapper.toDto(songBooks));
        return "songbooks";
    }
}
