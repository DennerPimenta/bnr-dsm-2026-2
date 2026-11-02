package br.edu.fatecfranca.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.fatecfranca.api.models.Turma;

public interface TurmaRepository
       extends MongoRepository<Turma, String> {

   List<Turma> findByCursoId(String cursoId);

   boolean existsByCursoId(String cursoId);
}