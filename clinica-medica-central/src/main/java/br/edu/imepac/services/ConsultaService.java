package br.edu.imepac.services;

import br.edu.imepac.dtos.consulta.ConsultaDto;
import br.edu.imepac.dtos.consulta.ConsultaRequest;
import br.edu.imepac.repositories.ConsultaRepository;
import br.edu.imepac.models.Consulta;
import br.edu.imepac.repositories.EspecialidadeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import br.edu.imepac.exceptions.NotFoundClinicaMedicaException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;

@Slf4j
@Service
public class ConsultaService {

    private ModelMapper modelMapper;
    private ConsultaRepository consultaRepository;

    public ConsultaService(ModelMapper modelMapper, ConsultaRepository consultaRepository) {
        this.modelMapper = modelMapper;
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


