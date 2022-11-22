package com.lhlibrary.backend.service;

import com.lhlibrary.backend.entity.Leitor;
import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.entity.Locacao;
import com.lhlibrary.backend.entity.Status;
import com.lhlibrary.backend.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoServiceImpl implements LocacaoService {
    @Autowired
    LocacaoRepository locacaoRepository;

    @Autowired
    LivroService livroService;

    @Autowired
    LeitorService leitorService;

    @Override
    public Locacao save(Locacao locacao) {
        Leitor leitor = leitorService.findById(locacao.getLeitor().getId());
        locacao.setLeitor(leitor);

        locacao.getItens().forEach(locacaoItem -> {
            Livro livro = livroService.findById(locacaoItem.getLivro().getId());
            locacaoItem.setLivro(livro);
            livro.setStatus(Status.INDISPONIVEL);
        });

        return locacaoRepository.save(locacao);
    }
}
