package com.lhlibrary.backend.controller;

import com.lhlibrary.backend.entity.Leitor;
import com.lhlibrary.backend.entity.Livro;
import com.lhlibrary.backend.service.LeitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leitor")
public class LeitorController {
    @Autowired
    LeitorService leitorService;

    @PostMapping
    public ResponseEntity<Leitor> createLeitor(@NonNull @RequestBody Leitor leitor) {
        return new ResponseEntity<>(leitorService.save(leitor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leitor> findLeitorById(@NonNull @PathVariable Long id) {
        return new ResponseEntity<>(leitorService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Leitor>> findLeitor(@RequestParam(name = "filtro", required = false) final String filtro) {
        if (filtro == null) {
            return new ResponseEntity<>(leitorService.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(leitorService.search(filtro), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leitor> updateLeitor(@NonNull @RequestBody Leitor leitor, @NonNull @PathVariable Long id) {
        leitor.setId(id);
        return new ResponseEntity<>(leitorService.updateLeitor(leitor), HttpStatus.OK);
    }
}
