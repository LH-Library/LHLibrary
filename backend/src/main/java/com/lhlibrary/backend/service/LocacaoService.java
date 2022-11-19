package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Locacao;
import org.springframework.lang.NonNull;

public interface LocacaoService {
    Locacao save(@NonNull Locacao locacao);
}
