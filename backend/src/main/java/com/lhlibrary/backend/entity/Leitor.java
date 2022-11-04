package com.lhlibrary.backend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Leitor extends Pessoa {
    private String cpf;
    private String telefone;
    @ManyToOne
    @JoinColumn(name="ID_ENDERECO", referencedColumnName = "ID")
    @EqualsAndHashCode.Exclude
    private Endereco endereco;
}
