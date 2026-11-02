package br.edu.fatecfranca.api.models;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Nota {

    @NotBlank(message = "A avaliação é obrigatória.")
    private String avaliacao;

    @NotNull(message = "O valor da nota é obrigatório.")
    @DecimalMin(value = "0.0", message = "A nota não pode ser menor que 0.")
    @DecimalMax(value = "10.0", message = "A nota não pode ser maior que 10.")
    private Double valor;

    public Nota() {
    }

    public Nota(String avaliacao, Double valor) {
        this.avaliacao = avaliacao;
        this.valor = valor;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}