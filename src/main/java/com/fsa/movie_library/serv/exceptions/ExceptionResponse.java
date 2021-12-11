package com.fsa.movie_library.serv.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponse {

    private int status;
    private String message;
    private OffsetDateTime createDateTime;
    private URI path;

    @JsonProperty("errors")
    private List<String> messages;

    public ExceptionResponse(HttpStatus status, OffsetDateTime createDateTime, URI path, List<String> messages) {
        this.status = status.value();
        this.message = status.getReasonPhrase();
        this.createDateTime = createDateTime;
        this.path = path;
        this.messages = messages;
    }

    public static ExceptionResponse of(HttpStatus status, OffsetDateTime createDateTime, URI path, List<String> messages) {
        return new ExceptionResponse(status, createDateTime, path, messages);
    }

}
