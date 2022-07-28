package com.fsa.movie_library.serv.model.services.impl;

import com.fsa.movie_library.serv.model.entities.Genre;
import com.fsa.movie_library.serv.model.repositories.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenreServiceImplTest {

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreServiceImpl genreService;

    private List<Genre> genres = new ArrayList<>();
    private List<Genre> genreList = Collections.emptyList();
    private Genre action;

    @BeforeEach
    public void setUp(){
        action = new Genre();
        action.setId(1);
        action.setName("Action");
        genres.add(action);
    }

    @Test
    public void whenFindAll_returnAllGenre() {
        when(genreRepository.findAll()).thenReturn(genres);

        List<Genre> genres = genreRepository.findAll();

        assertNotNull(genres);
        assertSame(Genre.class, genres.get(0).getClass());

        verify(genreRepository, times(1)).findAll();
    }

    @Test
    public void whenFindAll_returnListEmpty() {
        when(genreRepository.findAll()).thenReturn(genreList);

        List<Genre> genres = genreRepository.findAll();

        assertNotNull(genres);
        assertEquals(genreList, genres);

        verify(genreRepository, times(1)).findAll();
    }

    
}