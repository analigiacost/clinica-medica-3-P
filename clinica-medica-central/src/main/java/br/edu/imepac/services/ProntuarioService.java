package br.edu.imepac.services;

import br.edu.imepac.dtos.prontuario.ProntuarioDto;
import br.edu.imepac.dtos.prontuario.ProntuarioRequest;
import br.edu.imepac.models.Prontuario;
import br.edu.imepac.repositories.PronturioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import br.edu.imepac.exceptions.NotFoundClinicaMedicaException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProntuarioService {
    private ModelMapper modelMapper;
    private final PronturioRepository prontuarioRepository;

    public ProntuarioService(ModelMapper modelMapper, PronturioRepository pronturioRepository) {
        this.modelMapper = modelMapper;
        this.prontuarioRepository = pronturioRepository;
    }

    public ProntuarioDto adicionarProntuario(ProntuarioRequest prontuarioRequest) {
        log.info("Cadadastro de Prontuario - service: {}", prontuarioRequest);
        Prontuario prontuario = modelMapper.map(prontuarioRequest, Prontuario.class);
        prontuario = prontuarioRepository.save(prontuario);
        return modelMapper.map(prontuario, ProntuarioDto.class);
    }

    public ProntuarioDto atualizarProntuario(Long id, ProntuarioDto prontuarioDto) {
        log.info("Atualizando prontuario com ID: {}", id);
        Prontuario prontuarioExistente = prontuarioRepository.findById(id)
                .orElseThrow(()  -> new NotFoundClinicaMedicaException("Prontuario não encontrada com ID: " + id));
        modelMapper.map(prontuarioDto, prontuarioExistente);
        Prontuario prontuarioAtualizado = prontuarioRepository.save(prontuarioExistente);
        return modelMapper.map(prontuarioAtualizado, ProntuarioDto.class);
    }

    public void removerProntuario(Long id) {
        log.info("Removendo prontuario com ID: {}", id);
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("prontuario e não encontrada com ID: " + id));
        prontuarioRepository.delete(prontuario);
    }

    public ProntuarioDto buscarProntuarioPorId(Long id) {
        log.info("Buscando prontuario com ID: {}", id);
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("prontuario não encontrada com ID: " + id));
        return modelMapper.map(prontuario, ProntuarioDto.class);
    }

    public List<ProntuarioDto> listarProntuario() {
        log.info("Listando todos os prontuario");
        List<Prontuario> prontuarios = prontuarioRepository.findAll();
        return prontuarios.stream()
                .map(prontuario -> modelMapper.map(prontuarios, ProntuarioDto.class))
                .toList();
    }
}