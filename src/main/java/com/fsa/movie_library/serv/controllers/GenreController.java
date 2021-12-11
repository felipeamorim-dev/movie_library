package com.fsa.movie_library.serv.controllers;

import com.fsa.movie_library.serv.model.entities.dto.GenreDTO;
import com.fsa.movie_library.serv.model.services.impl.GenreServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/genres")
public class GenreController {

    private GenreServiceImpl genreService;

    public GenreController(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    @ResponseBody
    public List<GenreDTO> getAllGenre(){
        return genreService.getAllGenre();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public GenreDTO getGenreById(@PathVariable Integer id){
        return genreService.getGenreById(id);
    }
}
