package com.fsa.movie_library.serv.model.entities.mapper;

import com.fsa.movie_library.serv.model.entities.Movie;
import com.fsa.movie_library.serv.model.entities.dto.MovieDTO;
import com.fsa.movie_library.serv.model.entities.dto.ViewMovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieMapper {

    @Autowired
    private AdapterGenreMapper adapter;
    
    public MovieDTO fromEntityToDto(Movie movie){
        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;
    }

    //TODO: Implementar a adição dos gêneros quando converter de dto para entidade
    public Movie fromDtoToEntity(MovieDTO movieDTO){
        Movie movie = new Movie();
        GenreMapper genreMapper = new GenreMapper(adapter);

        movie.setId(movieDTO.getId());
        movie.setTitle(movieDTO.getTitle());
        movie.setReleaseYear(movieDTO.getReleaseYear());
        movie.setQuality(movieDTO.getQuality());
        movie.setDescription(movieDTO.getDescription());
        movie.setImageUrl(movieDTO.getImageUrl());
        movie.setUrl(movieDTO.getUrl());
        movie.setGenres(movieDTO.getGenres()
                .stream()
                .map(name -> genreMapper.fromStringToEntity(name)).collect(Collectors.toSet()));
        return movie;
    }

    public ViewMovieDTO fromEntityToViewDto(Movie movie){
        ViewMovieDTO viewDto= new ViewMovieDTO();
        viewDto.setId(movie.getId());
        viewDto.setTitle(movie.getTitle());
        viewDto.setReleaseYear(movie.getReleaseYear());
        viewDto.setImageUrl(movie.getImageUrl());
        viewDto.setGenre(movie.getGenres().iterator().next().getName());
        return viewDto;
    }
}
