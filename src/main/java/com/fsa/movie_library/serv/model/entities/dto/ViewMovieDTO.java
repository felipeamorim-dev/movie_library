package com.fsa.movie_library.serv.model.entities.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ViewMovieDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "Not found title")
    private String title;

    @NotNull(message = "Year of release cannot be null")
    private Integer releaseYear;

    private String imageUrl;

    @NotNull
    private String genre;

}
