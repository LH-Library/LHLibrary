package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.entity.Status;
import com.lhlibrary.backend.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@MockitoSettings
class LivroServiceTest {
    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroServiceImpl livroService;

    @Test
    void save() {
        //given
        Livro livro = new Livro(1L, "Teste", "Teste", "Teste", "Teste", 120, "Teste", "Teste", "Teste", Status.DISPONIVEL, "Teste",  true);
        ArgumentCaptor<Livro> captor = ArgumentCaptor.forClass(Livro.class);
        //when
        livroService.save(livro);
        //then
        verify(livroRepository, times(1)).save(captor.capture());
        assertEquals(captor.getValue(), livro);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void updateLivro() {
    }

    @Test
    void search() {
    }
}