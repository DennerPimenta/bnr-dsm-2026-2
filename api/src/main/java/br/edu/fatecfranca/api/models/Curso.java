
package br.edu.fatecfranca.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Document(collection = "cursos")
public class Curso {

  @Id
  private String id;

  @NotBlank(message = "O nome do curso é obrigatório.")
  private String nome;

  @NotNull(message = "A carga horária é obrigatória.")
  @Positive(message = "A carga horária deve ser maior que zero.")
  private Integer cargaHoraria;

  @NotNull(message = "O valor é obrigatório.")
  @PositiveOrZero(message = "O valor não pode ser negativo.")
  private Double valor;

  @Valid
  private List<Modulo> modulos;

  // Construtor genérico
  public Curso() {
  }

  // Construtor personalizado completo, com todos os atributos
  public Curso(
      String id,
      String nome,
      Integer cargaHoraria,
      Double valor,
      List<Modulo> modulos) {
    this.id = id;
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.valor = valor;
    this.modulos = modulos;

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(Integer cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public List<Modulo> getModulos() {
    return modulos;
  }

  public void setModulos(List<Modulo> modulos) {
    this.modulos = modulos;
  }
}
