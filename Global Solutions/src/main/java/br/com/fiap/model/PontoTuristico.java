package br.com.fiap.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class PontoTuristico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @NotEmpty
  private String nome;

  @Column(nullable = false)
  @NotEmpty
  private String categoria;

  @Column(nullable = false)
  @NotEmpty
  private String descricao;

  @Column(nullable = false)
  @NotEmpty
  private String localizacao;

  @Column(nullable = false)
  @NotEmpty
  private double valorMedio;

}
