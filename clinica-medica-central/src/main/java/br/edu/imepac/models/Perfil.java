package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perfil")

public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean cadastrarFuncionario;
    private boolean lerFuncionario;
    private boolean atualizarFuncionario;
    private boolean deletarFuncionario;
    private boolean listarFuncionario;
    private boolean cadastrarPaciente;
    private boolean lerPaciente;
    private boolean atualizarPaciente;
    private boolean listarPaciente;
    private boolean cadastrarConsulta;
    private boolean lerConsulta;
    private boolean atualizarConsulta;
    private boolean deletarConsulta;
    private boolean listaConsulta;
    private boolean cadastrarEspecialidade;
    private boolean lerEspecialidade;
    private boolean atualizarEspecialidade;
    private boolean deletarEspecialidade;
    private boolean listarEspecialidade;
    private boolean cadastrarConvenio;
    private boolean lerConvenio;
    private boolean atualizarConvenio;
    private boolean deletarConvenio;
    private boolean listarConvenio;
    private boolean cadastrarProntuario;
    private boolean lerProntuario;
    private boolean atualizarProntuario;
    private boolean deletarProntuario;
    private boolean listarProntuario;

    @OneToOne
    @JoinColumn (name = "Funcionario")
    private Funcionario funcionario;
}
