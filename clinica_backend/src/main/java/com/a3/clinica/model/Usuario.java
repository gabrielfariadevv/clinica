package com.a3.clinica.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;

    private Integer nivelAcesso;

    @OneToMany(mappedBy = "psicologo", cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "psicologo", cascade = CascadeType.ALL)
    private List<Prontuario> prontuarios;

    public enum TipoUsuario {
        PROFESSOR, ALUNO, ADMINISTRATIVO
    }

}
