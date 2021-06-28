package br.com.fiap.model;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Avaliacao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String comentario;

  @Column(nullable = false)
  private double nota;

  @Past
  private LocalDate dataComentario;

  @Column(nullable = false)
  private String avaliacaoID;
  
  public Avaliacao(){}
  
  
public Avaliacao(String comentario, double nota, LocalDate dataComentario, String avaliacaoID) {
	this.comentario = comentario;
	this.nota = nota;
	this.dataComentario = dataComentario;
	this.avaliacaoID = avaliacaoID;
}




public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getComentario() {
	return comentario;
}

public void setComentario(String comentario) {
	this.comentario = comentario;
}

public double getNota() {
	return nota;
}

public void setNota(double nota) {
	this.nota = nota;
}

public LocalDate getDataComentario() {
	return dataComentario;
}

public void setDataComentario(LocalDate dataComentario) {
	this.dataComentario = dataComentario;
}

public String getAvaliacaoID() {
	return avaliacaoID;
}

public void setAvaliacaoID(String avaliacaoID) {
	this.avaliacaoID = avaliacaoID;
}
  
  
  
}
