package br.edu.fatecfranca.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.fatecfranca.api.models.Instrutor;
import br.edu.fatecfranca.api.repositories.InstrutorRepository;

@Service
public class InstrutorService {

    private final InstrutorRepository repository;

    public InstrutorService(InstrutorRepository repository) {
        this.repository = repository;
    }

    // Regra do memorial: o CPF não pode se repetir entre instrutores
    private void verificarCpf(Instrutor instrutor) {
        boolean repetido = instrutor.getId() == null
                ? repository.existsByCpf(instrutor.getCpf())
                : repository.existsByCpfAndIdNot(instrutor.getCpf(), instrutor.getId());

        if (repetido) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Já existe um instrutor cadastrado com este CPF.");
        }
    }

    public List<Instrutor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Instrutor> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Instrutor salvar(Instrutor instrutor) {
        verificarCpf(instrutor);
        return repository.save(instrutor);
    }

    public void excluir(String id) {
        repository.deleteById(id);
    }
}