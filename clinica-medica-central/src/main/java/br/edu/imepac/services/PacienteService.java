package br.edu.imepac.services;

import br.edu.imepac.dtos.funcionario.FuncionarioDto;
import br.edu.imepac.dtos.funcionario.FuncionarioRequest;
import br.edu.imepac.dtos.paciente.PacienteDto;
import br.edu.imepac.dtos.paciente.PacienteRequest;
import br.edu.imepac.models.Funcionario;
import br.edu.imepac.models.Paciente;
import br.edu.imepac.repositories.FuncionarioRepository;
import br.edu.imepac.repositories.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import br.edu.imepac.exceptions.NotFoundClinicaMedicaException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PacienteService {

    private ModelMapper modelMapper;
    private PacienteRepository pacienteRepository;

    public PacienteService(ModelMapper modelMapper, PacienteRepository pacienteRepository) {
        this.modelMapper = modelMapper;
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteDto adicionarPaciente(PacienteRequest pacienteRequest) {
        log.info("Cadadastro de Paciente - service: {}", pacienteRequest);
        Paciente paciente = modelMapper.map(pacienteRequest, Paciente.class);
        paciente = pacienteRepository.save(paciente);
        return modelMapper.map(paciente, PacienteDto.class);
    }

    public PacienteDto atualizarPaciente(Long id, PacienteDto pacienteDto) {
        log.info("Atualizando paciente com ID: {}", id);
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(()  -> new NotFoundClinicaMedicaException("Paciente não encontrada com ID: " + id));
        modelMapper.map(pacienteDto, pacienteExistente);
        Paciente pacienteAtualizado = pacienteRepository.save(pacienteExistente);
        return modelMapper.map(pacienteAtualizado, PacienteDto.class);
    }

    public void removerPaciete(Long id) {
        log.info("Removendo Paciente com ID: {}", id);
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Paciente não encontrada com ID: " + id));
        pacienteRepository.delete(paciente);
    }

    public PacienteDto buscarPacientePorId(Long id) {
        log.info("Buscando Paciente com ID: {}", id);
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Paciente não encontrada com ID: " + id));
        return modelMapper.map(paciente, PacienteDto.class);
    }

    public List<PacienteDto> listarPaciente() {
        log.info("Listando todos os Pacientes");
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(paciente -> modelMapper.map(pacientes, PacienteDto.class))
                .toList();
    }
}
