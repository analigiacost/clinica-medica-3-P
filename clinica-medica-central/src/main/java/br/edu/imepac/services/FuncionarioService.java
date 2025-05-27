package br.edu.imepac.services;

import br.edu.imepac.dtos.funcionario.FuncionarioDto;
import br.edu.imepac.dtos.funcionario.FuncionarioRequest;
import br.edu.imepac.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void adicionarFuncionario(FuncionarioRequest funcionarioRequest) {

    }

    public void atualizarFuncionario(Long id, FuncionarioDto funcionarioDto) {

    }

    public void removerFuncionario(Long id) {

    }

    public FuncionarioDto buscarFuncionarioPorId(Long id) {

        return null;
    }

    public List<FuncionarioDto> listarFuncionario() {

        return null;
    }

}
