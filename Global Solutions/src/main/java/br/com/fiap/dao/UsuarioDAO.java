package br.com.fiap.dao;

import br.com.fiap.model.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Stateless
public class UsuarioDAO {

  @PersistenceContext
  private EntityManager entityManager;

  public List<Usuario> loadAllUsuarios(){
    return this.entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
  }

  public void delete(Usuario usuario){
    if (entityManager.contains(usuario)){
      entityManager.remove(usuario);
    } else {
      Usuario managedUsuario = entityManager.find(Usuario.class, usuario.getId());

      if (managedUsuario != null) {
        entityManager.remove(managedUsuario);
      }

    }
  }

  public void addNewUsuario(Usuario usuario){

    Usuario novoUsuario = new Usuario();
    novoUsuario.setUsuarioId(UUID.randomUUID().toString().substring(0, 8));
    novoUsuario.setNome(usuario.getNome());
    novoUsuario.setDataNascimento(usuario.getDataNascimento());
    novoUsuario.setEmail(usuario.getEmail());
    novoUsuario.setSenha(usuario.getSenha());

    this.entityManager.persist(novoUsuario);

  }

  public void update(List<Usuario> usuarios) {

    usuarios.forEach(entityManager::merge);

  }

}
