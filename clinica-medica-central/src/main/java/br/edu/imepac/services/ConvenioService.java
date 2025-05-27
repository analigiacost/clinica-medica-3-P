package br.edu.imepac.services;

import br.edu.imepac.dtos.convenio.ConvenioDto;
import br.edu.imepac.dtos.convenio.ConvenioRequest;
import br.edu.imepac.repositories.ConvenioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvenioService {
    private final ConvenioRepository convenioRepository;

    public ConvenioService(ConvenioRepository convenioRepository) {
        this.convenioRepository = convenioRepository;
    }

    public void adicionarConvenio(ConvenioRequest convenioRequest) {

    }

    public void atualizarConvenio(Long id, ConvenioDto convenioDto) {

    }

    public void removerConveio(Long id) {

    }

    public ConvenioDto buscarConveioPorId(Long id) {

        return null;
    }

    public List<ConvenioDto> listarConveio() {

        return null;
    }

}
