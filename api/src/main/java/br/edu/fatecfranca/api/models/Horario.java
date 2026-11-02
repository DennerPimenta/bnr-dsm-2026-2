package br.edu.fatecfranca.api.models;

import jakarta.validation.constraints.NotBlank;

public class Horario {

    @NotBlank(message = "O dia da semana é obrigatório.")
    private String diaSemana;

    @NotBlank(message = "O horário de início é obrigatório.")
    private String inicio;

    @NotBlank(message = "O horário de fim é obrigatório.")
    private String fim;

    public Horario() {
    }

    public Horario(String diaSemana, String inicio, String fim) {
        this.diaSemana = diaSemana;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }
}