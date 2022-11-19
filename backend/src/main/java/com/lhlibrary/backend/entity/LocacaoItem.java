package com.lhlibrary.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name="locacao_item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LocacaoItem implements Serializable {
    private static final long serialVersionUID = -5536885941019787444L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_livro", referencedColumnName = "id")
    @EqualsAndHashCode.Exclude
    private Livro livro;

    @Column(name="prazo_devolucao")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate prazoDevolucao;

    @Column(name="data_devolucao")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataDevolucao;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_locacao")
    @JsonBackReference
    private Locacao locacao;
}
