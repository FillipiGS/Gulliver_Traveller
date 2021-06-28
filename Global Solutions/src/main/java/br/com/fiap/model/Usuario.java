package br.com.fiap.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Past
  private LocalDate dataNascimento;

  @Column(nullable = false)
  @Email
  private String email;

  @Column(nullable = false)
  private String senha;

  @Column(nullable = false)
  private String usuarioId;

  public Usuario(){}

  public Usuario(String nome, LocalDate dataNascimento, String email, String senha, String usuarioId) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.email = email;
    this.senha = senha;
    this.usuarioId = usuarioId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(String usuarioId) {
    this.usuarioId = usuarioId;
  }
}
