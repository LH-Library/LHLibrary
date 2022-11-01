package com.lhlibrary.backend.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException(Long id) {
        super("Não foi possível encontar o livro " + id);
    }
}
