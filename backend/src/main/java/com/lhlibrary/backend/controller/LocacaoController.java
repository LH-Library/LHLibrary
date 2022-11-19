package com.lhlibrary.backend.controller;

import com.lhlibrary.backend.entity.Locacao;
import com.lhlibrary.backend.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/livros/retirada")
public class LocacaoController {
    @Autowired
    LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity<Locacao> createLivro(@NonNull @RequestBody Locacao locacao) {
        return new ResponseEntity<>(locacaoService.save(locacao), HttpStatus.CREATED);
    }
}
