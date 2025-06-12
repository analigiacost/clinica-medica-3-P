package br.edu.imepac.dtos.prontuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProntuarioDto {
    private long id;
    private String receituario;
    private String exames;
    private String observcoes;
}
