package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {
    @Autowired
    LivroRepository livroRepository;

    @Override
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    @Override
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    @Override
    public Livro updateLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public List<Livro> search(String filtro) {
        return livroRepository.findByTituloOrAutorContainingIgnoreCase(filtro);
    }

}
