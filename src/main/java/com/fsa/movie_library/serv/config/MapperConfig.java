package com.fsa.movie_library.serv.config;

import com.fsa.movie_library.serv.model.entities.mapper.AdapterGenreMapper;
import com.fsa.movie_library.serv.model.entities.mapper.GenreMapper;
import com.fsa.movie_library.serv.model.entities.mapper.MovieMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {GenreMapper.class, MovieMapper.class})
public class MapperConfig {

    @Bean
    public GenreMapper getGenreMapper(){
        return new GenreMapper();
    }

    @Bean
    public GenreMapper getGenreMapper(AdapterGenreMapper adapter){
        return new GenreMapper(adapter);
    }

    @Bean
    public MovieMapper getMovieMapper(){
        return new MovieMapper();
    }


}
