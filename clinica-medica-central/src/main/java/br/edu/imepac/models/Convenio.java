package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "convenio")

public class Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    private String receituario;
    private String exames;
    private String osbervacoes;

    @ManyToOne
    @JoinColumn(name = "Consulta")
    private Consulta consulta;

}
