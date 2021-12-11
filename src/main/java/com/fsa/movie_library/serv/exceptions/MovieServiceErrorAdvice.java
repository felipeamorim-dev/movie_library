package com.fsa.movie_library.serv.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;

@ControllerAdvice
@Slf4j
public class MovieServiceErrorAdvice {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e){
        return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    @ExceptionHandler({MovieNotFoundException.class})
    public ExceptionResponse handleMovieNotFoundException(MovieNotFoundException e){
        URI path = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand().toUri();
        //log.error("Exception : ", e);
        List<String> messages = List.of(e.getMessage());
        return ExceptionResponse.of(HttpStatus.NOT_FOUND, OffsetDateTime.now(), path, messages);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ExceptionResponse handleIllegalArgumentException(IllegalArgumentException e) {
        URI path = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand().toUri();
        List<String> messages = List.of(e.getMessage());
        return ExceptionResponse.of(HttpStatus.BAD_REQUEST, OffsetDateTime.now(), path, messages);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e){
        log.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
