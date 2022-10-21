package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroServiceImpl implements LivroService {
    @Autowired
    LivroRepository livroRepository;

    @Override
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }
}
