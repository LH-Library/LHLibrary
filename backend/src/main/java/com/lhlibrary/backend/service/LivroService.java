package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Livro;
import org.springframework.lang.NonNull;

import java.util.List;


public interface LivroService {
    Livro save(@NonNull Livro livro);

    Livro findById(@NonNull Long id);

    List<Livro> findAll();

    Livro updateLivro(@NonNull Livro livro);

    List<Livro> search(String filtro);
}
