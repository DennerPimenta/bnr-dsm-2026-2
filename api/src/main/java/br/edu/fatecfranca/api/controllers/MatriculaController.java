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


import br.edu.fatecfranca.api.models.Matricula;
import br.edu.fatecfranca.api.services.MatriculaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Matricula> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Matricula> criar(@Valid @RequestBody Matricula matricula) {
        Matricula matriculaSalva = service.salvar(matricula);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(matriculaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> atualizar(
            @PathVariable String id,
            @Valid @RequestBody Matricula matricula) {

        if (service.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        matricula.setId(id);

        Matricula matriculaAtualizada = service.salvar(matricula);

        return ResponseEntity.ok(matriculaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {

        if (service.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Matricula> listarPorAluno(
            @PathVariable String alunoId) {

        return service.listarPorAluno(alunoId);
    }

}