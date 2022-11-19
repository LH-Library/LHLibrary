package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Locacao;
import com.lhlibrary.backend.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoServiceImpl implements LocacaoService {
    @Autowired
    LocacaoRepository locacaoRepository;

    @Override
    public Locacao save(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }
}
