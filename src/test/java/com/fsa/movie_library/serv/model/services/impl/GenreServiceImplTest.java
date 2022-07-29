package com.fsa.movie_library.serv.model.services.impl;

import com.fsa.movie_library.serv.model.entities.Genre;
import com.fsa.movie_library.serv.model.entities.dto.GenreDTO;
import com.fsa.movie_library.serv.model.entities.mapper.GenreMapper;
import com.fsa.movie_library.serv.model.repositories.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenreServiceImplTest {

    public static final int ID = 1;
    public static final String ACTION = "Action";
    public static final String GENRE_NOT_FOUND = "Genre not found";

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private GenreMapper mapper;

    @InjectMocks
    private GenreServiceImpl genreService;

    private Genre action;
    private GenreDTO genreDTO;
    private Optional<Genre> genreOptional;

    @BeforeEach
    public void setUp(){
        action = new Genre();
        genreDTO = new GenreDTO();
        action.setId(ID);
        action.setName(ACTION);
        genreOptional = Optional.of(action);
        genreDTO.setId(ID);
        genreDTO.setName(ACTION);
    }

    @Test
    public void whenFindAll_returnAllGenre() {
        when(genreRepository.findAll()).thenReturn(List.of(action));
        when(mapper.fromEntityToDto(any())).thenReturn(genreDTO);

        List<GenreDTO> genreDTOListResult = genreService.getAllGenre();

        assertNotNull(genreDTOListResult);
        assertEquals(1, genreDTOListResult.size());
        assertSame(GenreDTO.class, genreDTOListResult.get(0).getClass());

        assertEquals(ID, genreDTOListResult.get(0).getId());
        assertEquals(ACTION, genreDTOListResult.get(0).getName());

        verify(genreRepository, times(1)).findAll();
    }

    @Test
    public void whenFindAll_returnListEmpty() {
        when(genreRepository.findAll()).thenReturn(Collections.emptyList());

        List<GenreDTO> genreDTOListResult = genreService.getAllGenre();

        assertNotNull(genreDTOListResult);
        assertEquals(0, genreDTOListResult.size());

        verify(genreRepository, times(1)).findAll();
    }

    @Test
    public void whenFindGenreById_returnGenreDTO() {
        when(genreRepository.findById(any())).thenReturn(genreOptional);
        when(mapper.fromEntityToDto(any())).thenReturn(genreDTO);

        GenreDTO genreDTOResult = genreService.getGenreById(ID);

        assertNotNull(genreDTOResult);
        assertEquals(GenreDTO.class, genreDTOResult.getClass());
        assertEquals(ID, genreDTOResult.getId());
        assertEquals(ACTION, genreDTOResult.getName());

        verify(genreRepository, times(1)).findById(ID);
    }

    @Test()
    public void whenFindGenreById_throwObjectNotFoundException() {
        when(genreRepository.findById(any()))
                .thenReturn(Optional.empty())
                .thenThrow(IllegalArgumentException.class);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            genreService.getGenreById(ArgumentMatchers.any());
        });

        assertEquals(IllegalArgumentException.class, illegalArgumentException.getClass());
        assertEquals(GENRE_NOT_FOUND, illegalArgumentException.getMessage());

        verify(genreRepository, times(1)).findById(ArgumentMatchers.any());
    }

}