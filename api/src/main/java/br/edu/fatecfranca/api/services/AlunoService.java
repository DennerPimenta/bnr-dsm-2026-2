
package br.edu.fatecfranca.api.services;


import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;


import br.edu.fatecfranca.api.models.Aluno;
import br.edu.fatecfranca.api.repositories.AlunoRepository;


@Service
public class AlunoService {


   private final AlunoRepository repository;


   public AlunoService(AlunoRepository repository) {
       this.repository = repository;
   }


   public List<Aluno> listarTodos() {
       return repository.findAll();
   }


   public Optional<Aluno> buscarPorId(String id) {
       return repository.findById(id);
   }


   public Aluno salvar(Aluno aluno) {
       return repository.save(aluno);
   }


   public void excluir(String id) {
       repository.deleteById(id);
   }
}

