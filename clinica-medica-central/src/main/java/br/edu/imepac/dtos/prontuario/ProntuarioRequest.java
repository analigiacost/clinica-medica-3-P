package br.edu.imepac.dtos.prontuario;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProntuarioRequest {
    private String receituario;
    private String exames;
    private String observcoes;
}
