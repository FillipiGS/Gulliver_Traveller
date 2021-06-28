package br.com.fiap.dao;


import br.com.fiap.model.Avaliacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Stateless
public class AvaliacaoDAO {
	
	  @PersistenceContext
	  private EntityManager entityManager;
	  
	  public List<Avaliacao> loadAllAvaliacoes(){
		  return this.entityManager.createQuery("SELECT a FROM Avaliacao a", Avaliacao.class).getResultList();
	  }
	  
	  public void delete(Avaliacao avaliacao) {
		  if (entityManager.contains(avaliacao)) {
			  entityManager.remove(avaliacao);
		  } else {
			  Avaliacao managedAvaliacao = entityManager.find(Avaliacao.class, avaliacao.getId());
			  
			  if ( managedAvaliacao != null) {
				  entityManager.remove(managedAvaliacao);
			  }
		  }
	  }
	  
	  public void addNewAvaliacao (Avaliacao avaliacao) {
		  Avaliacao novaAvaliacao = new Avaliacao();
		  novaAvaliacao.setAvaliacaoID(UUID.randomUUID().toString().substring(0 , 8));
		  novaAvaliacao.setComentario(avaliacao.getComentario());
		  novaAvaliacao.setDataComentario(avaliacao.getDataComentario());
		  novaAvaliacao.setNota(avaliacao.getNota());
		  
		  this.entityManager.persist(novaAvaliacao);
	  }
	  
	  public void update(List<Avaliacao> avaliacoes) {
		  avaliacoes.forEach(entityManager::merge);
	  }
	
}
