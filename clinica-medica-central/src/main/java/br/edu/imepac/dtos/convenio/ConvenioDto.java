package br.edu.imepac.dtos.convenio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvenioDto {
    public long id;
    private String receituario;
    private String exames;
    private String osbervacoes;
}
