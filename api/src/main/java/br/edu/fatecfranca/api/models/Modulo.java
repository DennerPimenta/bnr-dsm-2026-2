
package br.edu.fatecfranca.api.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Modulo {

        @NotBlank(message = "O título do módulo é obrigatório.")
        private String titulo;

        private String conteudo;

        @NotNull(message = "A carga horária do módulo é obrigatória.")
        @Positive(message = "A carga horária do módulo deve ser maior que zero.")
        private Integer cargaHoraria;

        public Modulo() {
        }

        public Modulo(
                        String titulo,
                        String conteudo,
                        Integer cargaHoraria) {
                this.titulo = titulo;
                this.conteudo = conteudo;
                this.cargaHoraria = cargaHoraria;

        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getConteudo() {
                return conteudo;
        }

        public void setConteudo(String conteudo) {
                this.conteudo = conteudo;
        }

        public Integer getCargaHoraria() {
                return cargaHoraria;
        }

        public void setCargaHoraria(Integer cargaHoraria) {
                this.cargaHoraria = cargaHoraria;
        }

}
