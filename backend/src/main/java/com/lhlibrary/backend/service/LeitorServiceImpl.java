package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Leitor;
import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.repository.EnderecoRepository;
import com.lhlibrary.backend.repository.LeitorRepository;
import com.lhlibrary.backend.service.exception.LeitorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Leitor findById(@NonNull Long id) {
        return leitorRepository.findById(id)
                .orElseThrow(() -> new LeitorNotFoundException(id));
    }

    public List<Leitor> findAll() {
        return leitorRepository.findAll();
    }

    @Override
    public Leitor updateLeitor(@NonNull Leitor leitor) {
        Leitor leitorAntigo = findById(leitor.getId());
        leitor.getEndereco().setId(leitorAntigo.getEndereco().getId());
        enderecoRepository.save(leitor.getEndereco());
        return leitorRepository.save(leitor);
    }

    @Override
    public List<Leitor> search(@NonNull String filtro) {
        return leitorRepository.findByNomeOrCpfContainingIgnoreCase(filtro);
    }
}
