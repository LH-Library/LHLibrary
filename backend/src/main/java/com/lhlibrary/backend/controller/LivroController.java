package com.lhlibrary.backend.controller;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {
    @Autowired
    LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {

        Livro livroResponse = livroService.save(livro);

        return new ResponseEntity<>(livroResponse, HttpStatus.CREATED);
    }
}
