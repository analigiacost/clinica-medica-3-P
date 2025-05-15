package br.edu.imepac.dtos.funcionario;

import java.time.LocalDate;

public class FuncionarioRequest {

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class FuncionarioRequest {
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

}
