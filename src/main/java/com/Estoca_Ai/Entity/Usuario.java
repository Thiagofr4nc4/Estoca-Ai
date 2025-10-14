package com.Estoca_Ai.Entity;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", columnDefinition = "VARCHAR(255) NOT NULL")
    private String nome;
}
