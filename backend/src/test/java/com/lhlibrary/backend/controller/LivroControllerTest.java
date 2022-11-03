package com.lhlibrary.backend.controller;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.entity.Status;
import com.lhlibrary.backend.service.LivroService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@MockitoSettings
class LivroControllerTest {

    @Mock
    private LivroService livroService;

    @InjectMocks
    private LivroController livroController;

    Livro livro = new Livro(1L, "Teste", "Teste", "Teste", "Teste", 120, "Teste", "Teste", "Teste", Status.DISPONIVEL, "Teste",  true);

    @Test
    void createLivro() {
        when(livroService.save(livro)).thenReturn(livro);

        ResponseEntity<Livro> response = livroController.createLivro(livro);

        assertEquals(livro, response.getBody());
    }

    @Test
    void findLivroById() {
        when(livroService.findById(1L)).thenReturn(livro);

        ResponseEntity<Livro> response = livroController.findLivroById(1L);

        assertEquals(livro, response.getBody());
    }

    @Test
    void findLivroAll() {
        when(livroService.findAll()).thenReturn(List.of(livro));

        ResponseEntity<List<Livro>> response = livroController.findLivro(null);

        assertEquals(List.of(livro), response.getBody());
    }

    @Test
    void findLivroComFiltro() {
        when(livroService.search("teste")).thenReturn(List.of(livro));

        ResponseEntity<List<Livro>> response = livroController.findLivro("teste");

        assertEquals(List.of(livro), response.getBody());
    }

    @Test
    void updateLivro() {
        Livro livroAlterado = new Livro(1L, "Teste", "Teste", "Teste", "Teste", 120, "Teste", "Teste", "Teste", Status.DISPONIVEL, "Teste",  false);
        when(livroService.updateLivro(livroAlterado)).thenReturn(livroAlterado);

        ResponseEntity<Livro> response = livroController.updateLivro(livroAlterado, 1L);

        assertEquals(livroAlterado, response.getBody());
    }
}