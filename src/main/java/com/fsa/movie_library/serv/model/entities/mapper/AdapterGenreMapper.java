package com.fsa.movie_library.serv.model.entities.mapper;

import com.fsa.movie_library.serv.model.entities.Genre;
import com.fsa.movie_library.serv.model.repositories.GenreRepository;
import org.springframework.stereotype.Component;

@Component
public class AdapterGenreMapper {

   private GenreRepository genreRepository;

    public AdapterGenreMapper(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre findByName(String name){
        if(name == null) throw new IllegalArgumentException();
        return genreRepository.findByName(name);
    }
}
