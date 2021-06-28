package br.com.fiap.beans;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

  private List<Usuario> usuarios;

  private Usuario usuario = new Usuario();

  @Inject
  private UsuarioDAO usuarioDao;

  @PostConstruct
  public void init() {
    this.usuarios = usuarioDao.loadAllUsuarios();
  }

  public void delete(Usuario usuario){
    usuarioDao.delete(usuario);
    usuarios.remove(usuario);
  }

  public void add() throws IOException {
    usuarioDao.addNewUsuario(usuario);
    this.usuarios = usuarioDao.loadAllUsuarios();
    this.usuario = new Usuario();
    FacesContext.getCurrentInstance().getExternalContext().redirect("ponto-turistico.xhtml");
  }

  public void update() {
    usuarioDao.update(usuarios);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado com sucesso!"));
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public UsuarioDAO getUsuarioDao() {
    return usuarioDao;
  }

  public void setUsuarioDao(UsuarioDAO usuarioDao) {
    this.usuarioDao = usuarioDao;
  }
}
