package com.fsa.movie_library.serv.exceptions;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException (String message){
        super(message);
    }
}
