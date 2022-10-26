package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroService {
    Livro save(Livro livro);

    Optional<Livro> findById(Long id);

    List<Livro> findAll();

    Livro updateLivro(Livro livro);

    List<Livro> search(String filtro);
}
