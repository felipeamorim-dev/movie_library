package com.fsa.movie_library.serv.controllers;

import com.fsa.movie_library.serv.model.entities.dto.GenreDTO;
import com.fsa.movie_library.serv.model.services.GenreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenreControllerTest {

    private static final Integer ID = 1;
    private static final String ACTION = "Action";
    public static final String GENRE_NOT_FOUND = "Genre not found";

    private static GenreDTO GENRE_DTO = new GenreDTO();

    @Mock
    private GenreService service;

    @InjectMocks
    private GenreController genreController;

    @BeforeEach
    public void setUp() {
        GENRE_DTO.setId(ID);
        GENRE_DTO.setName(ACTION);
    }

    @Test
    public void getAllGenre_ReturnListOfGenreDTO_WhenGetAll(){
        when(service.getAllGenre()).thenReturn(List.of(GENRE_DTO));
        List<GenreDTO> genreDTOList = genreController.getAllGenre();

        assertNotNull(genreDTOList);
        assertEquals(1, genreDTOList.size());
        assertTrue(genreDTOList.get(0).getName().equalsIgnoreCase(ACTION));

        verify(service, times(1)).getAllGenre();
    }

    @Test
    public void getGenreById_ReturnGenreDTO_WhenGetById(){
        when(service.getGenreById(anyInt())).thenReturn(GENRE_DTO);

        GenreDTO genreDTOResult = genreController.getGenreById(ID);

        assertNotNull(genreDTOResult);
        assertEquals(GenreDTO.class, genreDTOResult.getClass());
        assertTrue(genreDTOResult.equals(GENRE_DTO));

        verify(service, times(1)).getGenreById(ID);
    }

    @Test
    public void getGenreById_ThrowIllegalArgumentException_WhenIdInvalid(){
        when(service.getGenreById(anyInt())).thenThrow(new IllegalArgumentException(GENRE_NOT_FOUND));

        Exception exceptionResult = assertThrows(IllegalArgumentException.class, () -> {
            genreController.getGenreById(ArgumentMatchers.anyInt());
        });

        assertEquals(IllegalArgumentException.class, exceptionResult.getClass());
        assertEquals(GENRE_NOT_FOUND, exceptionResult.getMessage());

        verify(service, times(1)).getGenreById(ArgumentMatchers.anyInt());
    }

}