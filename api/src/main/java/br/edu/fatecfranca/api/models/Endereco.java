package br.edu.fatec.projeto.model;


public class Endereco {


   private String logradouro;
   private String numero;
   private String municipio;
   private String uf;
   private String cep;


   public Endereco() {
   }


   public Endereco(
           String logradouro,
           String numero,
           String municipio,
           String uf,
           String cep) {
       this.logradouro = logradouro;
       this.numero = numero;
       this.municipio = municipio;
       this.uf = uf;
       this.cep = cep;
   }


   //*


}
