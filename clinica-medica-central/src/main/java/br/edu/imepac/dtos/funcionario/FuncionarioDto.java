package br.edu.imepac.dtos.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDto {
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
    }

