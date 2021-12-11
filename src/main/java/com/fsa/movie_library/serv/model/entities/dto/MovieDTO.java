package com.fsa.movie_library.serv.model.entities.dto;

import com.fsa.movie_library.serv.model.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
public class MovieDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "Not found title")
    private String title;

    @NotNull(message = "Year of release cannot be null")
    private Integer releaseYear;

    @NotNull(message = "Quality cannot be null")
    private Integer quality;

    @NotNull(message = "Description cannot be null")
    private String description;

    private String imageUrl;

    private String url;

    private Set<String> genres = new HashSet<>();

    public MovieDTO(Movie movie){
        setId(movie.getId());
        setTitle(movie.getTitle());
        setReleaseYear(movie.getReleaseYear());
        setQuality(movie.getQuality());
        setDescription(movie.getDescription());
        setImageUrl(movie.getImageUrl());
        setUrl(movie.getUrl());
        setGenres(movie.getGenres().stream().map(x -> x.getName()).collect(Collectors.toSet()));
    }
}
