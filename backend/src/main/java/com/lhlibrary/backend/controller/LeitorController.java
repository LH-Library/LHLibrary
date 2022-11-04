package com.lhlibrary.backend.controller;

import com.lhlibrary.backend.entity.Leitor;
import com.lhlibrary.backend.service.LeitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/leitor")
public class LeitorController {
    @Autowired
    LeitorService leitorService;

    @PostMapping
    public ResponseEntity<Leitor> createLeitor(@NonNull @RequestBody Leitor leitor) {
        return new ResponseEntity<>(leitorService.save(leitor), HttpStatus.CREATED);
    }
}
