package com.a3.clinica.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_consulta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataConsulta;

    @Column(name = "hora_consulta", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaConsulta;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Usuario psicologo;

    @Lob
    private String anotacoes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum Status {
        REALIZADA, CANCELADA, AGENDADA
    }

}

