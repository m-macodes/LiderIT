package ru.macodes.liderit.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SightException extends RuntimeException {
    public SightException(String message) {
        super(message);
    }
}
