package br.edu.fatecfranca.api.dtos;


import java.time.LocalDate;
import java.util.List;


import br.edu.fatecfranca.api.models.*;


public record TurmaResponse(
       String id,
       String cursoId,
       String instrutorId,
       LocalDate inicio,
       LocalDate fim,
       Integer vagas,
       List<Horario> horarios,
       Curso curso,
       Instrutor instrutor) {
}
