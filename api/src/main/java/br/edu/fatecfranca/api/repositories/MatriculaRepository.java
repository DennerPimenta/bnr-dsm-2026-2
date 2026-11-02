package br.edu.fatecfranca.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.fatecfranca.api.models.Matricula;

public interface MatriculaRepository
        extends MongoRepository<Matricula, String> {

    List<Matricula> findByAlunoId(String alunoId);

    boolean existsByAlunoId(String alunoId);

    boolean existsByTurmaId(String turmaId);

    // Regra: mesmo aluno não pode ter duas matrículas na mesma turma
    boolean existsByAlunoIdAndTurmaId(String alunoId, String turmaId);

    boolean existsByAlunoIdAndTurmaIdAndIdNot(String alunoId, String turmaId, String id);

    // Regra: matrículas ativas não podem passar das vagas
    long countByTurmaIdAndSituacaoIgnoreCase(String turmaId, String situacao);

    long countByTurmaIdAndSituacaoIgnoreCaseAndIdNot(String turmaId, String situacao, String id);
}