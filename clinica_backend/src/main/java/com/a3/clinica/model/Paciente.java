package com.a3.clinica.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(length = 15)
    private String telefone;

    @Column(length = 100)
    private String email;

    private String endereco;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Prontuario prontuario;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Relatorio> relatorios;

}

