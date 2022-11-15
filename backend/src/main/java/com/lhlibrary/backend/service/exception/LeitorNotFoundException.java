package com.lhlibrary.backend.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class LeitorNotFoundException extends RuntimeException {
        public LeitorNotFoundException(Long id) {
            super("Não foi possível encontar o leitor " + id);
        }
    }
