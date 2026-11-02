package br.edu.fatecfranca.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.fatecfranca.api.models.Aluno;
import br.edu.fatecfranca.api.repositories.AlunoRepository;
import br.edu.fatecfranca.api.repositories.MatriculaRepository;

@Service
public class AlunoService {

    private final AlunoRepository repository;
    private final MatriculaRepository matriculaRepository;

    public AlunoService(AlunoRepository repository, MatriculaRepository matriculaRepository) {
        this.repository = repository;
        this.matriculaRepository = matriculaRepository;
    }

    // Regra do memorial: o CPF não pode se repetir entre alunos
    private void verificarCpf(Aluno aluno) {
        boolean repetido = aluno.getId() == null
                ? repository.existsByCpf(aluno.getCpf())
                : repository.existsByCpfAndIdNot(aluno.getCpf(), aluno.getId());

        if (repetido) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Já existe um aluno cadastrado com este CPF.");
        }
    }

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Optional<Aluno> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Aluno salvar(Aluno aluno) {
        verificarCpf(aluno);
        return repository.save(aluno);
    }

    public void excluir(String id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Aluno não encontrado.");
        }

        if (matriculaRepository.existsByAlunoId(id)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Não é possível excluir um aluno com matrículas vinculadas.");
        }

        repository.deleteById(id);
    }
}