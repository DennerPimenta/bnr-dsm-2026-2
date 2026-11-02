
package br.edu.fatecfranca.api.models;

import jakarta.validation.constraints.NotBlank;

public class Endereco {

@NotBlank(message = "O logradouro é obrigatório.")
   private String logradouro;
@NotBlank(message = "O numero é obrigatório.")   
   private String numero;

@NotBlank(message = "O municipio é obrigatório.")      
   private String municipio;
 @NotBlank(message = "A UF é obrigatória.")
   private String uf;
 @NotBlank(message = "A cep é obrigatória.")
   private String cep;


   public Endereco() {
   }


   public Endereco(String logradouro, String numero, String municipio, String uf, String cep) {
       this.logradouro = logradouro;
       this.numero = numero;
       this.municipio = municipio;
       this.uf = uf;
       this.cep = cep;
   }


   public String getLogradouro() {
    return logradouro;
   }


   public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
   }


   public String getNumero() {
    return numero;
   }


   public void setNumero(String numero) {
    this.numero = numero;
   }


   public String getMunicipio() {
    return municipio;
   }


   public void setMunicipio(String municipio) {
    this.municipio = municipio;
   }


   public String getUf() {
    return uf;
   }


   public void setUf(String uf) {
    this.uf = uf;
   }


   public String getCep() {
    return cep;
   }


   public void setCep(String cep) {
    this.cep = cep;
   }


   


   //*


}

