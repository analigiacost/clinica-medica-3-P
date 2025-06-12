package br.edu.imepac.services;

import br.edu.imepac.dtos.paciente.PacienteDto;
import br.edu.imepac.dtos.paciente.PacienteRequest;
import br.edu.imepac.repositories.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void adicionarPaciente(PacienteRequest pacienteRequest) {

    }

    public void atualizarPaciente(Long id, PacienteDto pacienteDto) {

    }

    public void removerPaciente(Long id) {

    }

    public PacienteDto buscarPacientePorId(Long id) {

        return null;
    }

    public List<PacienteDto> listarPaciente() {

        return null;
    }
}
