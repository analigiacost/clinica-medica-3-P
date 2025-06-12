package br.edu.imepac.models;

import java.time.LocalDate;
import br.edu.imepac.domain.EnumTipoFuncionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "funcionario")

    public class Funcionario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String usuario;
        private int senha;
        private String nome;
        private int idade;
        private char sexo;
        private String cpf;
        private String rua;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String estado;
        private String contato;
        private String email;
        private LocalDate nascimento;

        @Enumerated(EnumType.STRING)
        private EnumTipoFuncionario tipoFuncionario;

        @OneToOne
        @JoinColumn (name = "Especialidade")
        private Especialidade especialidade;

        @OneToOne
        @JoinColumn (name = "EnumTipoFuncionario")
        private EnumTipoFuncionario enumTipoFuncionario;

        @OneToOne
        @JoinColumn (name = "Perfil")
        private Perfil perfil;

        @ManyToOne
        @JoinColumn (name = "Consulta")
        private Consulta consulta;
    }

