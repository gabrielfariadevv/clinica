package com.a3.clinica.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id", nullable = false, unique = true)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Usuario psicologo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private Date dataCriacao = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ultima_atualizacao")
    private Date ultimaAtualizacao = new Date();

    @Lob
    private String observacoes;

    @PreUpdate
    protected void onUpdate() {
        ultimaAtualizacao = new Date();
    }
}
