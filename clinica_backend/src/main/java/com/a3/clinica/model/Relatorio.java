package com.a3.clinica.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_relatorio", nullable = false)
    private TipoRelatorio tipoRelatorio;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_geracao", nullable = false)
    private Date dataGeracao = new Date();

    @Lob
    private String conteudo;

    public enum TipoRelatorio {
        PRESENCA, EVOLUCAO, OUTRO
    }

}

