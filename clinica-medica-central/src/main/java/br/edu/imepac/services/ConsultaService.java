package br.edu.imepac.services;

import br.edu.imepac.dtos.consulta.ConsultaDto;
import br.edu.imepac.dtos.consulta.ConsultaRequest;
import br.edu.imepac.models.Consulta;
import br.edu.imepac.repositories.ConsultaRepository;
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
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ModelMapper modelMapper, ConsultaRepository consultaRepository) {
        this.modelMapper = modelMapper;
        this.consultaRepository = consultaRepository;
    }

    public ConsultaDto adicionarConsulta(ConsultaRequest consultaRequest) {
        log.info("Cadadastro de Consulta - service: {}", consultaRequest);
        Consulta consulta = modelMapper.map(consultaRequest, Consulta.class);
        consulta = consultaRepository.save(consulta);
        return modelMapper.map(consulta, ConsultaDto.class);
    }

    public ConsultaDto atualizarConsulta(Long id, ConsultaDto consultaDto) {
        log.info("Atualizando Consulta com ID: {}", id);
        Consulta consultaExistente = consultaRepository.findById(id).orElseThrow(() -> new NotFoundClinicaMedicaException("Consulta não encontrada com ID: " + id));
        modelMapper.map(consultaDto, consultaExistente);
        Consulta consultaAtualizada = consultaRepository.save(consultaExistente);
        return modelMapper.map(consultaAtualizada, ConsultaDto.class);
    }

    public void removerConsulta(Long id) {
        log.info("Removendo Consulta com ID: {}", id);
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new NotFoundClinicaMedicaException("Consulta não encontrada com ID: " + id));
        consultaRepository.delete(consulta);
    }

    public ConsultaDto buscarConsultaPorId(Long id) {
        log.info("Buscando Consulta com ID: {}", id);
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new NotFoundClinicaMedicaException("Consulta não encontrada com ID: " + id));
        return modelMapper.map(consulta, ConsultaDto.class);
    }

    public List<ConsultaDto> listarConsulta() {
        log.info("Listando todas as Consulta");
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas.stream().map(consulta -> modelMapper.map(consulta, ConsultaDto.class)).toList();
    }

}