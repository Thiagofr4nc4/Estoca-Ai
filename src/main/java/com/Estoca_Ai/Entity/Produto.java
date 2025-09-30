package com.Estoca_Ai.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", columnDefinition = "VARCHAR(255) NOT NULL")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private int preco;

    @Column(name = "desconto")
    private int desconto;

    @Column(name = "estoque")
    private int estoque;

    @Column(name = "validade")
    private LocalDate validade;

    public Produto() {}

}
