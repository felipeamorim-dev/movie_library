package com.fsa.movie_library.serv.model.repositories;

import com.fsa.movie_library.serv.model.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    @Query("select u from Genre u where u.name = ?1")
    Genre findByName(String name);
}
