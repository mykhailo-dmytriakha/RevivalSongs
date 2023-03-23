package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.RevivalSongsApp;
import org.example.model.SongBook;
import org.example.repo.SongBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RevivalSongsApp.class)
@AutoConfigureMockMvc
class SongBookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SongBookRepository songBookRepository;

    private List<SongBook> songBooks;

    @BeforeEach
    public void setUp() {
        songBookRepository.deleteAll();
        songBooks = Arrays.asList(
                new SongBook("Song Book 1"),
                new SongBook("Song Book 2")
        );
        songBookRepository.saveAll(songBooks);
    }

    @Test
    void testGetAllSongBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/songbooks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.length()").value(songBooks.size()));
    }

    @Test
    void testGetSongBookById() throws Exception {
        SongBook songBook = songBooks.get(0);
        mockMvc.perform(MockMvcRequestBuilders.get("/songbooks/{id}", songBook.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.title").value(songBook.getTitle()));
    }

    @Test
    void testCreateSongBook() throws Exception {
        SongBook songBook = new SongBook("New Song Book");
        mockMvc.perform(MockMvcRequestBuilders.post("/songbooks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(songBook)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.songBookId").isNotEmpty())
                .andExpect(jsonPath("$.title").value(songBook.getTitle()));
    }

    @Test
    void testUpdateSongBook() throws Exception {
        SongBook songBook = songBooks.get(0);
        SongBook updatedSongBook = new SongBook("Updated Song Book");
        mockMvc.perform(MockMvcRequestBuilders.put("/songbooks/{id}", songBook.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedSongBook)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.songBookId").value(songBook.getId()))
                .andExpect(jsonPath("$.title").value(updatedSongBook.getTitle()));
    }

    @Test
    void testDeleteSongBook() throws Exception {
        SongBook songBook = songBooks.get(0);
        mockMvc.perform(MockMvcRequestBuilders.delete("/songbooks/{id}", songBook.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/songbooks/{id}", songBook.getId()))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
