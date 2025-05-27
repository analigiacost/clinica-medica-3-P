package br.edu.imepac.services;

import br.edu.imepac.dtos.perfil.PerfilDto;
import br.edu.imepac.dtos.perfil.PerfilRequest;
import br.edu.imepac.repositories.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {
    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public void adicionarPerfil(PerfilRequest perfilRequest) {

    }

    public void atualizarPerfil(Long id, PerfilDto perfilDto) {

    }

    public void removerPerfil(Long id) {

    }

    public PerfilDto buscarPerfilPorId(Long id) {

        return null;
    }

    public List<PerfilDto> listarPerfil() {

        return null;
    }

}
