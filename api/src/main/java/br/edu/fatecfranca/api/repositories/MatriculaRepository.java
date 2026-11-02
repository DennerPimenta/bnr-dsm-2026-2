package br.edu.fatecfranca.api.repositories;


import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;


import br.edu.fatecfranca.api.models.Matricula;


public interface MatriculaRepository
       extends MongoRepository<Matricula, String> {

   List<Matricula> findByAlunoId(String alunoId);

   boolean existsByAlunoId(String alunoId);

   boolean existsByTurmaId(String turmaId);
}