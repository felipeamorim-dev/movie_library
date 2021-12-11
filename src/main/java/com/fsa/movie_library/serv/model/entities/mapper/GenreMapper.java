package com.fsa.movie_library.serv.model.entities.mapper;

import com.fsa.movie_library.serv.model.entities.Genre;
import com.fsa.movie_library.serv.model.entities.dto.GenreDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenreMapper {
    
    private AdapterGenreMapper adapter;

    public GenreMapper(AdapterGenreMapper adapter){
        this.adapter = adapter;
    }

    public GenreDTO fromEntityToDto(Genre genre){
        GenreDTO dto = new GenreDTO();
        dto.setId(genre.getId());
        dto.setName(genre.getName());
        return dto;
    }

    public Genre fromDtoToEntity(GenreDTO genreDTO){
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        return genre;
    }

    public Genre fromStringToEntity(String genre){
        Genre obj = adapter.findByName(genre);
        return obj;
    }
}
