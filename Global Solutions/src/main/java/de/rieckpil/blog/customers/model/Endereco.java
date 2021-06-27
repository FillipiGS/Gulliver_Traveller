package de.rieckpil.blog.customers.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @NotEmpty
  private String logradouro;

  @Column(nullable = false)
  @NotEmpty
  private String endereço;

  @Column(nullable = false)
  @NotEmpty
  private Long numero;

  @Column(nullable = false)
  @NotEmpty
  private String cep;

  @Column(nullable = false)
  @NotEmpty
  private String cidade;

  @Column(nullable = false)
  @NotEmpty
  private String estado;

  public Endereco(){

  }

  public Endereco(Long id, String logradouro, String endereço, Long numero, String cep, String cidade, String estado) {
    this.id = id;
    this.logradouro = logradouro;
    this.endereço = endereço;
    this.numero = numero;
    this.cep = cep;
    this.cidade = cidade;
    this.estado = estado;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getEndereço() {
    return endereço;
  }

  public void setEndereço(String endereço) {
    this.endereço = endereço;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
}
