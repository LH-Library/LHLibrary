package com.lhlibrary.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Locacao implements Serializable {

    private static final long serialVersionUID = -6724599963234767434L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_LEITOR", referencedColumnName = "ID")
    @EqualsAndHashCode.Exclude
    private Leitor leitor;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @EqualsAndHashCode.Exclude
    private Usuario usuario;

    @Column(name="data_locacao")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataLocacao;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "locacao")
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private List<LocacaoItem> itens = new ArrayList<>();
}
