package br.edu.imepac.services;

import br.edu.imepac.dtos.especialidade.EspecialidadeDto;
import br.edu.imepac.dtos.especialidade.EspecialidadeRequest;
import br.edu.imepac.repositories.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {
    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    public void adicionarEspecialidade(EspecialidadeRequest especialidadeRequest) {
    }

    public void atualizarEspecialidade(Long id, EspecialidadeDto especialidadeDto) {
    }

    public void removerEspecialidade(Long id) {
    }

    public EspecialidadeDto buscarEspecialidadePorId(Long id) {
        return null;
    }

    public List<EspecialidadeDto> listarEspecialidades() {
        return null;
    }

}
