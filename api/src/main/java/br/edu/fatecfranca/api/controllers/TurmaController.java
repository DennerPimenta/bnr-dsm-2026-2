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

import br.edu.fatecfranca.api.dtos.TurmaResponse;
import br.edu.fatecfranca.api.models.Turma;
import br.edu.fatecfranca.api.services.TurmaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

   private final TurmaService service;

   public TurmaController(TurmaService service) {
       this.service = service;
   }

   @GetMapping
   public List<TurmaResponse> listarTodos() {
       return service.listarComDetalhes();
   }

   @GetMapping("/{id}")
   public ResponseEntity<TurmaResponse> buscarPorId(
           @PathVariable String id) {
       return service.buscarComDetalhes(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
   }

   @GetMapping("/curso/{cursoId}")
   public List<TurmaResponse> listarPorCurso(
           @PathVariable String cursoId) {
       return service.listarPorCursoComDetalhes(cursoId);
   }

   @PostMapping
   public ResponseEntity<Turma> criar(@Valid @RequestBody Turma turma) {
       Turma turmaSalva = service.salvar(turma);

       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(turmaSalva);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Turma> atualizar(
           @PathVariable String id,
           @Valid @RequestBody Turma turma) {

       if (service.buscarPorId(id).isEmpty()) {
           return ResponseEntity.notFound().build();
       }

       turma.setId(id);

       Turma turmaAtualizada = service.salvar(turma);

       return ResponseEntity.ok(turmaAtualizada);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> excluir(@PathVariable String id) {
       service.excluir(id);
       return ResponseEntity.noContent().build();
   }
}