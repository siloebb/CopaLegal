/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import crud.JogoCRUD;
import crud.SelecaoCRUD;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Fase;
import model.Jogo;
import model.Selecao;

/**
 *
 * @author suka
 */
@ManagedBean
public class JogoController {
    private Jogo jogo;
    private Long selecao1Selecionada;
    private Long selecao2Selecionada;
    private  List<Selecao> listaSelecoes;
    private  List<Jogo> listaJogo;
   
   public JogoController(){
       listaSelecoes = iniciarListaSelecoes();
       jogo = new Jogo();
       listaJogo = iniciarListaJogo();
   }
   public void excluir(Long id){
       JogoCRUD jcrud = new JogoCRUD();
        Jogo ready = jcrud.ready(id);
        try {
            jcrud.delete(ready);
            listaJogo = iniciarListaJogo();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage("Erro ao excluir! Verifique se o dado não está dependente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
   }
    public List<Jogo> getListaJogo() {
        return listaJogo;
    }

    public void setListaJogo(List<Jogo> listaJogo) {
        this.listaJogo = listaJogo;
    }
   
   public void cadastrarJogo(){
        JogoCRUD ccrud = new JogoCRUD();
        SelecaoCRUD scrud = new SelecaoCRUD();
        Selecao s1 = scrud.ready(selecao1Selecionada);
        Selecao s2 = scrud.ready(selecao2Selecionada);
        jogo.setS1(s1);
        jogo.setS2(s2);
        jogo.setFase(Fase.FINAL);
        ccrud.create(jogo);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaJogo = iniciarListaJogo();
    }

    public List<Selecao> getListaSelecoes() {
        return listaSelecoes;
    }

    public void setListaSelecoes(List<Selecao> listaSelecoes) {
        this.listaSelecoes = listaSelecoes;
    }
    

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Long getSelecao1Selecionada() {
        return selecao1Selecionada;
    }

    public void setSelecao1Selecionada(Long selecao1Selecionada) {
        this.selecao1Selecionada = selecao1Selecionada;
    }

    public Long getSelecao2Selecionada() {
        return selecao2Selecionada;
    }

    public void setSelecao2Selecionada(Long selecao2Selecionada) {
        this.selecao2Selecionada = selecao2Selecionada;
    }

    private List<Selecao> iniciarListaSelecoes() {
        SelecaoCRUD sCrud = new SelecaoCRUD();
        List<Selecao> list = sCrud.getList();
        return list;
    }
    private List<Jogo> iniciarListaJogo() {
        JogoCRUD jCrud = new JogoCRUD();
        List<Jogo> list = jCrud.getList();
        return list;
    }
    
}
