package br.edu.fatecfranca.api.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {


  @GetMapping("/")
  public String hello() {
      return "API em funcionamento!";
  }

 @GetMapping("/test")
   public String test() {
       return "Isto é um teste.";
   }

}
