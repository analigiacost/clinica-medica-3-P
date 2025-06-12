package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    private LocalDateTime dataHorario;
    private String sintomas;
    private boolean eRetorno;
    private boolean estaAtiva;

    @OneToMany
    @JoinColumn(name = "Funcionario")
    private Funcionario funcionario;

    @OneToOne
    @JoinColumn(name = "Prontuario")
    private Prontuario prontuario;

    @OneToMany
    @JoinColumn(name = "Convenio")
    private Convenio convenio;

    @OneToOne
    @JoinColumn(name = "Paciente")
    private Paciente paciente;
}
