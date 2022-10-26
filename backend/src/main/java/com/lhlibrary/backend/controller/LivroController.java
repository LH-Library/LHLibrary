package com.lhlibrary.backend.controller;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findLivroById(@PathVariable Long id) {
        Optional<Livro> livro = livroService.findById(id);

        return livro.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping
    public ResponseEntity<List<Livro>> findLivro(@RequestParam(name = "filtro", required = false) final String filtro) {
        if (filtro == null) {
            return new ResponseEntity<>(livroService.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(livroService.search(filtro), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@RequestBody Livro livro, @PathVariable Long id) {
        livro.setId(id);
        return new ResponseEntity<>(livroService.updateLivro(livro), HttpStatus.NO_CONTENT);
    }
}
