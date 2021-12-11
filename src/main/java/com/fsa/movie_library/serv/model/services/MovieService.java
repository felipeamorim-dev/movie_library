package com.fsa.movie_library.serv.model.services;

import com.fsa.movie_library.serv.model.entities.dto.MovieDTO;
import com.fsa.movie_library.serv.model.entities.dto.ViewMovieDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {

    Page<MovieDTO> getAllMovie(Pageable pageable);

    Page<ViewMovieDTO> getAllViewMovie(Pageable pageable);

    MovieDTO getMovieById(Integer id);

    MovieDTO saveMovie(MovieDTO movieDTO);

    MovieDTO updateMovieById(Integer id, MovieDTO movie);

    void deleteMovieById(Integer id);

}
