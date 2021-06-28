package br.com.fiap.beans;

import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.model.Avaliacao;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AvaliacaoBean implements Serializable {

    private List<Avaliacao> avaliacoes;

    private Avaliacao avaliacao = new Avaliacao();

    @Inject
    private AvaliacaoDAO avaliacaoDAO;

    @PostConstruct
    public void init() {
        this.avaliacoes = avaliacaoDAO.loadAllAvaliacoes();
    }

    public void delete(Avaliacao avaliacao) {
        avaliacaoDAO.delete(avaliacao);
        avaliacoes.remove(avaliacao);
    }

    public void add(){
        avaliacaoDAO.addNewAvaliacao(avaliacao);
        this.avaliacoes = avaliacaoDAO.loadAllAvaliacoes();
        this.avaliacao = new Avaliacao();
    }

    public void update() {
        avaliacaoDAO.update(avaliacoes);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Comentário editado com sucesso!"));
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public AvaliacaoDAO getAvaliacaoDAO() {
        return avaliacaoDAO;
    }

    public void setAvaliacaoDAO(AvaliacaoDAO avaliacaoDAO) {
        this.avaliacaoDAO = avaliacaoDAO;
    }
}
