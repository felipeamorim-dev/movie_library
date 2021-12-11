package com.fsa.movie_library.serv.model.entities.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class GenreDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

}
