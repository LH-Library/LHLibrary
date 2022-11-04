package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Leitor;
import com.lhlibrary.backend.repository.EnderecoRepository;
import com.lhlibrary.backend.repository.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeitorServiceImpl implements LeitorService {
    @Autowired
    LeitorRepository leitorRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public Leitor save(Leitor leitor) {
        enderecoRepository.save(leitor.getEndereco());
        return leitorRepository.save(leitor);
    }
}
