package br.edu.imepac.services;

import br.edu.imepac.dtos.convenio.ConvenioDto;
import br.edu.imepac.dtos.convenio.ConvenioRequest;
import br.edu.imepac.dtos.funcionario.FuncionarioDto;
import br.edu.imepac.dtos.funcionario.FuncionarioRequest;
import br.edu.imepac.models.Convenio;
import br.edu.imepac.models.Funcionario;
import br.edu.imepac.repositories.ConvenioRepository;
import br.edu.imepac.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import br.edu.imepac.exceptions.NotFoundClinicaMedicaException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Service
public class FuncionarioService {

    private ModelMapper modelMapper;
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(ModelMapper modelMapper, FuncionarioRepository funcionarioRepository) {
        this.modelMapper = modelMapper;
        this.funcionarioRepository = funcionarioRepository;
    }

    public FuncionarioDto adicionarFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("Cadadastro de Funcionario - service: {}", funcionarioRequest);
        Funcionario funcionario = modelMapper.map(funcionarioRequest, Funcionario.class);
        funcionario = funcionarioRepository.save(funcionario);
        return modelMapper.map(funcionario, FuncionarioDto.class);
    }

    public FuncionarioDto atualizarFuncionario(Long id, FuncionarioDto funcionarioDto) {
        log.info("Atualixando funcionario com ID: {}", id);
        Funcionario funcionarioExistente = funcionarioRepository.findById(id)
                    .orElseThrow(()  -> new NotFoundClinicaMedicaException("Funcionario não encontrada com ID: " + id));
        modelMapper.map(funcionarioDto, funcionarioExistente);
        Funcionario funcionarioAtualizada = funcionarioRepository.save(funcionarioExistente);
        return modelMapper.map(funcionarioAtualizada, FuncionarioDto.class);
    }

    public void removerFuncionario(Long id) {
        log.info("Removendo Funcionario com ID: {}", id);
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Funcionario não encontrada com ID: " + id));
        funcionarioRepository.delete(funcionario);
    }

    public FuncionarioDto buscarFuncionarioPorId(Long id) {
        log.info("Buscando Funcionario com ID: {}", id);
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Funcionario não encontrada com ID: " + id));
        return modelMapper.map(funcionario, FuncionarioDto.class);
    }

    public List<FuncionarioDto> listarFuncionario() {
        log.info("Listando todas as Funcionario");
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                .map(funcionario -> modelMapper.map(funcionario, FuncionarioDto.class))
                .toList();
    }
}
