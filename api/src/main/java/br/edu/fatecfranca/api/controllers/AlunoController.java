package br.edu.fatecfranca.api.controllers;


import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.edu.fatecfranca.api.models.Aluno;
import br.edu.fatecfranca.api.services.AlunoService;


@RestController
@RequestMapping("/alunos")
public class AlunoController {


   private final AlunoService service;


   public AlunoController(AlunoService service) {
       this.service = service;
   }


   @GetMapping
   public List<Aluno> listarTodos() {
       return service.listarTodos();
   }


   @GetMapping("/{id}")
   public ResponseEntity<Aluno> buscarPorId(@PathVariable String id) {
       return service.buscarPorId(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
   }


   @PostMapping
   public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
       Aluno alunoSalvo = service.salvar(aluno);


       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(alunoSalvo);
   }


   @PutMapping("/{id}")
   public ResponseEntity<Aluno> atualizar(
           @PathVariable String id,
           @RequestBody Aluno aluno) {


       if (service.buscarPorId(id).isEmpty()) {
           return ResponseEntity.notFound().build();
       }


       aluno.setId(id);


       Aluno alunoAtualizado = service.salvar(aluno);


       return ResponseEntity.ok(alunoAtualizado);
   }


   @DeleteMapping("/{id}")
   public ResponseEntity<Void> excluir(@PathVariable String id) {


       if (service.buscarPorId(id).isEmpty()) {
           return ResponseEntity.notFound().build();
       }


       service.excluir(id);


       return ResponseEntity.noContent().build();
   }
}
