package com.fsa.movie_library.serv.model.repositories;

import com.fsa.movie_library.serv.model.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @EntityGraph(attributePaths = "genres")
    Page<Movie> findAll(Pageable pageable);
}
