package br.edu.fatecfranca.api.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;


import br.edu.fatecfranca.api.models.Aluno;


public interface AlunoRepository
       extends MongoRepository<Aluno, String> {
}
