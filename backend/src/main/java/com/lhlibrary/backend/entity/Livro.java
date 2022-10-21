package com.lhlibrary.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Livro implements Serializable {
    private static final long serialVersionUID = 2273622175668001182L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String editora;
    private String edicao;
    private int paginas;
    private String idioma;
    private String genero;
    private String status;
    private String isbn;
    private boolean ativo;
}
