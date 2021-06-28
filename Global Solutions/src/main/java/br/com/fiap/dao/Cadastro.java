package br.com.fiap.dao;


import br.com.fiap.model.Usuario;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.UUID;

@Startup
@Singleton
public class Cadastro {

  private EntityManager entityManager;

  public void init() {
    System.out.println("Cadastro do usuário!");
  }

  private Usuario criarUsuario(String nome, LocalDate dataNascimento, String email, String senha) {
    Usuario resultado = new Usuario();

    resultado.setNome(nome);
    resultado.setDataNascimento(dataNascimento);
    resultado.setEmail(email);
    resultado.setSenha(senha);
    resultado.setUsuarioId(UUID.randomUUID().toString().substring(0, 8));
    return resultado;
  }

}
