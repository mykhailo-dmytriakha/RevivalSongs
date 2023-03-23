package org.example.repo;

import org.example.model.SongBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongBookRepository extends MongoRepository<SongBook, String> {

    List<SongBook> findAllByOrderByTitleAsc();

    List<SongBook> findByTitleContainingIgnoreCase(String keyword);

    Optional<SongBook> findById(String id);
}


