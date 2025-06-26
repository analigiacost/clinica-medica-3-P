package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


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

    @OneToMany
    @JoinColumn(name = "Consulta")
    private List<Consulta> consulta;

}
