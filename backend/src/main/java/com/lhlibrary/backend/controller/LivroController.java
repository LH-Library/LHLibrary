package com.lhlibrary.backend.controller;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {
    @Autowired
    LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> createLivro(@NonNull @RequestBody Livro livro) {
        return new ResponseEntity<>(livroService.save(livro), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findLivroById(@NonNull @PathVariable Long id) {
        return new ResponseEntity<>(livroService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findLivro(@RequestParam(name = "filtro", required = false) final String filtro) {
        if (filtro == null) {
            return new ResponseEntity<>(livroService.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(livroService.search(filtro), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@NonNull @RequestBody Livro livro, @NonNull @PathVariable Long id) {
        livro.setId(id);
        return new ResponseEntity<>(livroService.updateLivro(livro), HttpStatus.OK);
    }
}
