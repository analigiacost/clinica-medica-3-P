package br.edu.imepac.services;

import br.edu.imepac.dtos.convenio.ConvenioDto;
import br.edu.imepac.dtos.convenio.ConvenioRequest;
import br.edu.imepac.models.Convenio;
import br.edu.imepac.repositories.ConvenioRepository;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import br.edu.imepac.exceptions.NotFoundClinicaMedicaException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;

@Slf4j
@Service
public class ConvenioService {

    private ModelMapper modelMapper;
    private ConvenioRepository convenioRepository;

    public ConvenioService(ModelMapper modelMapper, ConvenioRepository convenioRepository) {
        this.modelMapper = modelMapper;
        this.convenioRepository = convenioRepository;
    }

    public ConvenioDto adicionarConvenio(ConvenioRequest convenioRequest) {
        log.info("Cadadastro de Convenio - service: {}", convenioRequest);
        Convenio convenio = modelMapper.map(convenioRequest, Convenio.class);
        convenio = convenioRepository.save(convenio);
        return modelMapper.map(convenio, ConvenioDto.class);
    }

    public ConvenioDto atualizarConvenio(Long id, ConvenioDto convenioDto) {
        log.info("Atualixando convenio com ID: {}", id);
        Convenio convenioExistente = convenioRepository.findById(id)
                .orElseThrow(()  -> new NotFoundClinicaMedicaException("convenio não encontrada com ID: " + id));
        modelMapper.map(convenioDto, convenioExistente);
        Convenio convenioAtualizada = convenioRepository.save(convenioExistente);
        return modelMapper.map(convenioAtualizada, ConvenioDto.class);
    }

    public void removerConvenio(Long id) {
        log.info("Removendo convenio com ID: {}", id);
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("convenio não encontrada com ID: " + id));
        convenioRepository.delete(convenio);
    }

    public ConvenioDto buscarConvenioPorId(Long id) {
        log.info("Buscando Convenio com ID: {}", id);
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("convenio não encontrada com ID: " + id));
        return modelMapper.map(convenio, ConvenioDto.class);
    }

    public List<ConvenioDto> listarConvenio() {
        log.info("Listando todas as convenio");
        List<Convenio> convenios = convenioRepository.findAll();
        return convenios.stream()
                .map(convenio -> modelMapper.map(convenio, ConvenioDto.class))
                .toList();
    }

}
