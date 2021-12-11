package com.fsa.movie_library.serv.model.services;

import com.fsa.movie_library.serv.model.entities.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    List<GenreDTO> getAllGenre();
    GenreDTO getGenreById(Integer id);

}
