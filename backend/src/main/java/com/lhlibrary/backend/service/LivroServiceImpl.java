package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.repository.LivroRepository;
import com.lhlibrary.backend.service.exception.LivroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {
    @Autowired
    LivroRepository livroRepository;

    @Override
    public Livro save(@NonNull Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public Livro findById(@NonNull Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new LivroNotFoundException(id));
    }

    @Override
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    @Override
    public Livro updateLivro(@NonNull Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public List<Livro> search(@NonNull String filtro) {
        return livroRepository.findByTituloOrAutorContainingIgnoreCase(filtro);
    }

}
