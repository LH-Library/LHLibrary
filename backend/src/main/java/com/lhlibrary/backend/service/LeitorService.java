package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Leitor;
import com.lhlibrary.backend.entity.Livro;
import org.springframework.lang.NonNull;

import java.util.List;

public interface LeitorService {
    Leitor save(@NonNull Leitor leitor);

    Leitor findById(@NonNull Long id);

    List<Leitor> findAll();

    Leitor updateLeitor(@NonNull Leitor leitor);

    List<Leitor> search(String filtro);
}
