package br.edu.imepac.services;

import br.edu.imepac.dtos.prontuario.ProntuarioDto;
import br.edu.imepac.dtos.prontuario.ProntuarioRequest;
import br.edu.imepac.repositories.PronturioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProntuarioService {
    private final PronturioRepository pronturioRepository;

    public ProntuarioService(PronturioRepository pronturioRepository) {
        this.pronturioRepository = pronturioRepository;
    }

    public void adicionarProntuario(ProntuarioRequest prontuarioRequest) {

    }

    public void atualizarProntuario(Long id, ProntuarioDto prontuarioDto) {

    }

    public void removerProntuario(Long id) {

    }

    public ProntuarioDto buscarProntuarioPorId(Long id) {

        return null;
    }

    public List<ProntuarioDto> listarProntuario() {

        return null;
    }
}
