package com.lhlibrary.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private String local;
    private String idioma;
    private String genero;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String isbn;
    private boolean ativo;
}
