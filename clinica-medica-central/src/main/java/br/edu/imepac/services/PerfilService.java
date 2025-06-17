package br.edu.imepac.services;

import br.edu.imepac.dtos.perfil.PerfilDto;
import br.edu.imepac.dtos.perfil.PerfilRequest;
import br.edu.imepac.models.Perfil;
import br.edu.imepac.repositories.PacienteRepository;
import br.edu.imepac.repositories.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import br.edu.imepac.exceptions.NotFoundClinicaMedicaException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PerfilService {
    private ModelMapper modelMapper;
    private PerfilRepository perfilRepository;

    public PerfilService(ModelMapper modelMapper, PerfilRepository perfilRepository) {
        this.modelMapper = modelMapper;
        this.perfilRepository = perfilRepository;
    }

    public PerfilDto adicionarPerfil(PerfilRequest perfilRequest) {
        log.info("Cadadastro de Perfil - service: {}", perfilRequest);
        Perfil perfil = modelMapper.map(perfilRequest, Perfil.class);
        perfil = perfilRepository.save(perfil);
        return modelMapper.map(perfil, PerfilDto.class);
    }

    public PerfilDto atualizarPerfil(Long id, PerfilDto perfilDto) {
        log.info("Atualizando paerfil com ID: {}", id);
        Perfil perfilExistente = perfilRepository.findById(id)
                .orElseThrow(()  -> new NotFoundClinicaMedicaException("Perfil não encontrada com ID: " + id));
        modelMapper.map(perfilDto, perfilExistente);
        Perfil perfilAtualizado = perfilRepository.save(perfilExistente);
        return modelMapper.map(perfilAtualizado, PerfilDto.class);
    }

    public void removerPerfil(Long id) {
        log.info("Removendo Perfil com ID: {}", id);
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Perfile não encontrada com ID: " + id));
        perfilRepository.delete(perfil);
    }

    public PerfilDto buscarPerfilPorId(Long id) {
        log.info("Buscando Perfil com ID: {}", id);
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Perfil não encontrada com ID: " + id));
        return modelMapper.map(perfil, PerfilDto.class);
    }

    public List<PerfilDto> listarPerfil() {
        log.info("Listando todos os Perfil");
        List<Perfil> perfils = perfilRepository.findAll();
        return perfils.stream()
                .map(perfil -> modelMapper.map(perfils, PerfilDto.class))
                .toList();
    }
}