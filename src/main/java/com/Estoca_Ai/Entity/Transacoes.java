package com.Estoca_Ai.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Produto produto;

    private int quantidade;

    private String tipo; //Se é uma entrada ou saída de produtos

    private LocalDateTime data;

    private String responsavel;

    private String solicitante;


}
