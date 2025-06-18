package br.edu.imepac.services;

import br.edu.imepac.dtos.consulta.ConsultaDto;
import br.edu.imepac.dtos.consulta.ConsultaRequest;
import br.edu.imepac.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public void adicionarConsulta(ConsultaRequest consultaRequest) {

    }

    public void atualizarConsulta(Long id, ConsultaDto consultaDto) {

    }

    public void removerConsulta(Long id) {

    }

    public ConsultaDto buscarConsultaPorId(Long id) {

        return null;
    }

    public List<ConsultaDto> listarConsulta() {

        return null;
    }

}


