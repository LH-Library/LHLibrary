package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.entity.Status;
import com.lhlibrary.backend.repository.LivroRepository;
import com.lhlibrary.backend.service.exception.LivroNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@MockitoSettings
class LivroServiceTest {
    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroServiceImpl livroService;

    Livro livro = new Livro(1L, "Teste", "Teste", "Teste", "Teste", 120, "Teste", "Teste", "Teste", Status.DISPONIVEL, "Teste",  true);

    @Test
    void save() {
        ArgumentCaptor<Livro> captor = ArgumentCaptor.forClass(Livro.class);

        livroService.save(livro);

        verify(livroRepository, times(1)).save(captor.capture());
        assertEquals(captor.getValue(), livro);
    }

    @Test
    void findById() {
        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        Livro livroEncontrado = livroService.findById(1L);

        verify(livroRepository, times(1)).findById(1L);
        assertEquals(livro, livroEncontrado);
    }

    @Test
    void findByIdLivroNaoEncontrado() {
        assertThrowsExactly(LivroNotFoundException.class,
                () -> livroService.findById(2L));
    }

    @Test
    void findAll() {
        when(livroRepository.findAll()).thenReturn(List.of(livro));

        List<Livro> listLivroEncontrado = livroService.findAll();

        verify(livroRepository, times(1)).findAll();
        assertEquals(List.of(livro), listLivroEncontrado);
    }

    @Test
    void updateLivro() {
        ArgumentCaptor<Livro> captor = ArgumentCaptor.forClass(Livro.class);
        Livro livroAlterado = new Livro(1L, "Teste", "Teste", "Teste", "Teste", 120, "Teste", "Teste", "Teste", Status.DISPONIVEL, "Teste",  false);

        livroService.updateLivro(livroAlterado);

        verify(livroRepository, times(1)).save(captor.capture());
        assertEquals(captor.getValue(), livroAlterado);
    }

    @Test
    void search() {
        when(livroRepository.findByTituloOrAutorContainingIgnoreCase("teste")).thenReturn(List.of(livro));

        List<Livro> listLivroEncontrado = livroService.search("teste");

        verify(livroRepository, times(1)).findByTituloOrAutorContainingIgnoreCase("teste");
        assertEquals(List.of(livro), listLivroEncontrado);
    }
}