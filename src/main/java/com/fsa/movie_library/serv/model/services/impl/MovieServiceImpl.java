package com.fsa.movie_library.serv.model.services.impl;

import com.fsa.movie_library.serv.exceptions.MovieNotFoundException;
import com.fsa.movie_library.serv.model.entities.Movie;
import com.fsa.movie_library.serv.model.entities.dto.MovieDTO;
import com.fsa.movie_library.serv.model.entities.dto.ViewMovieDTO;
import com.fsa.movie_library.serv.model.entities.mapper.MovieMapper;
import com.fsa.movie_library.serv.model.repositories.MovieRepository;
import com.fsa.movie_library.serv.model.services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private MovieMapper movieMapper;

    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public Page<MovieDTO> getAllMovie(Pageable pageable) {
        Page<Movie> movies = movieRepository.findAll(pageable);
        return movies.map(movie -> movieMapper.fromEntityToDto(movie));
    }

    @Override
    public Page<ViewMovieDTO> getAllViewMovie(Pageable pageable) {
        Page<Movie> movies = movieRepository.findAll(pageable);
        return movies.map(movie -> movieMapper.fromEntityToViewDto(movie));
    }

    @Override
    public MovieDTO getMovieById(Integer id) {
        return movieMapper.fromEntityToDto(
                movieRepository.findById(id)
                        .orElseThrow(() -> new MovieNotFoundException("Movie not found")));
    }

    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        Movie newMovie = movieMapper.fromDtoToEntity(movieDTO);
        Movie returnMovie = movieRepository.save(newMovie);
        return movieMapper.fromEntityToDto(returnMovie);
    }

    @Override
    public MovieDTO updateMovieById(Integer id, MovieDTO movie) {
        Movie oldMovie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Entity Not Found"));
        Movie updateMovie = movieRepository.save(updateMovie(oldMovie, movieMapper.fromDtoToEntity(movie)));
        return movieMapper.fromEntityToDto(updateMovie);
    }

    @Override
    public void deleteMovieById(Integer id) {
        movieRepository.deleteById(id);
    }

    private Movie updateMovie(Movie oldMovie, Movie newMovie){
        if (newMovie.getTitle() != null) oldMovie.setTitle(newMovie.getTitle());
        if (newMovie.getReleaseYear() != null) oldMovie.setReleaseYear(newMovie.getReleaseYear());
        if (newMovie.getQuality() != null) oldMovie.setQuality(newMovie.getQuality());
        if (newMovie.getDescription() != null) oldMovie.setDescription(newMovie.getDescription());
        if (!newMovie.getGenres().isEmpty()) oldMovie.setGenres(newMovie.getGenres());
        if(newMovie.getUrl() != null) oldMovie.setUrl(newMovie.getUrl());
        if(newMovie.getUrl() != null) oldMovie.setImageUrl(newMovie.getImageUrl());
        return oldMovie;
    }
}

