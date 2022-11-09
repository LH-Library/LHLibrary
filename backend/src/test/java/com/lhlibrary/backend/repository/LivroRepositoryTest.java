package com.lhlibrary.backend.repository;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.entity.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LivroRepositoryTest {
    @Autowired
    LivroRepository livroRepository;

    @Test
    void findByTituloOrAutorContainingIgnoreCase() {
        Livro livro = new Livro(1L, "Titulo", "Teste", "Teste", "Teste", 120, "Teste", "Teste", "Teste", Status.DISPONIVEL, "Teste",  true);
        livroRepository.save(livro);
        Integer countLivro = livroRepository.findAll().size();
        assertEquals(1, countLivro);
        List<Livro> livroBuscado = livroRepository.findByTituloOrAutorContainingIgnoreCase("titulo");

        assertNotNull(livroBuscado);
        assertEquals(livro, livroBuscado.get(0));
    }

    @Test
    void findByTituloOrAutorContainingIgnoreCaseSemRetorno() {
        Livro livro = new Livro(1L, "Titulo", "Teste", "Teste", "Teste", 120, "Teste", "Teste", "Teste", Status.DISPONIVEL, "Teste",  true);
        livroRepository.save(livro);
        Integer countLivro = livroRepository.findAll().size();
        assertEquals(1, countLivro);
        List<Livro> livroBuscado = livroRepository.findByTituloOrAutorContainingIgnoreCase("invalido");

        assertTrue(livroBuscado.isEmpty());
    }
}