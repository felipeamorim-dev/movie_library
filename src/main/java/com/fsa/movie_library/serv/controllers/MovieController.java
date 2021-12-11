package com.fsa.movie_library.serv.controllers;

import com.fsa.movie_library.serv.exceptions.MovieNotFoundException;
import com.fsa.movie_library.serv.model.entities.dto.MovieDTO;
import com.fsa.movie_library.serv.model.entities.dto.ViewMovieDTO;
import com.fsa.movie_library.serv.model.services.impl.MovieServiceImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieServiceImpl movieService;

    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ResponseBody
    public Page<MovieDTO> findAllMovie(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "5") Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<MovieDTO> moviesDto = movieService.getAllMovie(pageable);
        return moviesDto;
    }

    @GetMapping("/views")
    @ResponseBody
    public Page<ViewMovieDTO> findAllViewMovie(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "5") Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ViewMovieDTO> viewMoviesDto = movieService.getAllViewMovie(pageable);
        return viewMoviesDto;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public MovieDTO findMovieById(@PathVariable Integer id){
        MovieDTO obj;
        try {
            obj = movieService.getMovieById(id);
        }catch (MovieNotFoundException e){
            throw new MovieNotFoundException(e.getMessage());
        }
        return obj;
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MovieDTO create(@RequestBody @Valid MovieDTO movieDTO){
        return movieService.saveMovie(movieDTO);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MovieDTO updateMovie(@PathVariable Integer id, @RequestBody @Valid MovieDTO movieDTO){
           return movieService.updateMovieById(id, movieDTO);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Integer id){
        try {
            movieService.deleteMovieById(id);
        }catch (EmptyResultDataAccessException e){
            throw new MovieNotFoundException(e.getMessage());
        }
    }

}
