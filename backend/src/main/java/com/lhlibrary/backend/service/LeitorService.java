package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Leitor;
import org.springframework.lang.NonNull;

public interface LeitorService {
    Leitor save(@NonNull Leitor leitor);
}
