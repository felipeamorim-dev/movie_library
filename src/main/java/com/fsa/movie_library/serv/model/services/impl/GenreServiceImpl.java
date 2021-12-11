package com.fsa.movie_library.serv.model.services.impl;

import com.fsa.movie_library.serv.model.entities.dto.GenreDTO;
import com.fsa.movie_library.serv.model.entities.mapper.GenreMapper;
import com.fsa.movie_library.serv.model.repositories.GenreRepository;
import com.fsa.movie_library.serv.model.services.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;
    private GenreMapper genreMapper;

    public GenreServiceImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public List<GenreDTO> getAllGenre() {
        return genreRepository.findAll()
                .stream().map(ent -> genreMapper.fromEntityToDto(ent))
                .collect(Collectors.toList());
    }

    @Override
    public GenreDTO getGenreById(Integer id) {
        return genreRepository.findById(id)
                .map(genreMapper::fromEntityToDto)
                .orElseThrow(() -> new IllegalArgumentException("Genre not found"));
    }
}
