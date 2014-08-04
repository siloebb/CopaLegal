/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import crud.EscalacaoCRUD;
import crud.JogadorCRUD;
import crud.SelecaoCRUD;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Escalacao;
import model.Jogador;
import model.Selecao;

/**
 *
 * @author Bianca
 */
@ManagedBean
public class EscalacaoController {
  
    private Escalacao escalacao;
    private List<Escalacao> listaEscalacoes;
    
    private List<Selecao> listaSelecoes;
    private Long selecaoSelecionada;
    
    private List<Jogador> listaJogadores;
    private List<Long> listaJogadorSelecionado1;
    
    
    public EscalacaoController() {
        listaSelecoes = iniciarListaSelecoes();
        listaJogadores = iniciarListaJogadores();
        this.escalacao = new Escalacao();
        listaEscalacoes = iniciarListaEscalacoes();
        
    }

    public Long getSelecaoSelecionada() {
        return selecaoSelecionada;
    }

    public void setSelecaoSelecionada(Long selecaoSelecionada) {
        this.selecaoSelecionada = selecaoSelecionada;
    }

    public Escalacao getEscalacao() {
        return escalacao;
    }

    public List<Long> getListaJogadorSelecionado1() {
        return listaJogadorSelecionado1;
    }

    public void setListaJogadorSelecionado1(List<Long> listaJogadorSelecionado1) {
        this.listaJogadorSelecionado1 = listaJogadorSelecionado1;
    }
    
    public void setEscalacao(Escalacao escalacao) {
        this.escalacao = escalacao;
    }

    public List<Escalacao> getListaEscalacoes() {
        return listaEscalacoes;
    }

    public void setListaEscalacoes(List<Escalacao> listaEscalacoes) {
        this.listaEscalacoes = listaEscalacoes;
    }
    
    public void nada(){
        FacesMessage message1 = new FacesMessage("Faz alguma coisa pela'mor de nós");
        FacesContext.getCurrentInstance().addMessage(null, message1);
        System.out.println("PASSANDO");
    }
    
    public void cadastrarEscalacao() {
        FacesMessage message1 = new FacesMessage("Faz alguma coisa pela'mor de nós");
        FacesContext.getCurrentInstance().addMessage(null, message1);
        
        System.out.println("passo1");
        SelecaoCRUD scrud = new SelecaoCRUD();
        Selecao selecao = scrud.ready(selecaoSelecionada);
        escalacao.setSelecao(selecao);      
        System.out.println("passo2");
        ArrayList<Jogador> listaJogadoresMarotos = new ArrayList<Jogador>();
        JogadorCRUD jcrud = new JogadorCRUD();
        for(int i=0;i<listaJogadorSelecionado1.size();i++){
            Long get = Long.parseLong( "" + listaJogadorSelecionado1.get(i));
            
            Jogador ready = jcrud.ready(get);
            listaJogadoresMarotos.add(ready);
        }
        escalacao.setJogadores(listaJogadoresMarotos);
        System.out.println("passo3");
        
        EscalacaoCRUD ecrud = new EscalacaoCRUD();

        ecrud.create(escalacao);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaEscalacoes = iniciarListaEscalacoes();
    }
    
    public List<Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public void setListaJogadores(List<Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }
    
    
    public List<Jogador> iniciarListaJogadores(){
             
        JogadorCRUD jCrud = new JogadorCRUD();
        List<Jogador> list = jCrud.getList();
        return list;
    }
    public List<Selecao> iniciarListaSelecoes(){
        SelecaoCRUD sCrud = new SelecaoCRUD();
        List<Selecao> list = sCrud.getList();
        return list;
    }
    
    private List<Escalacao> iniciarListaEscalacoes() {
        EscalacaoCRUD ecrud = new EscalacaoCRUD();
        List<Escalacao> list = ecrud.getList();
        return list;
    }
    
    public void excluirEscalacao(Long id) {
        EscalacaoCRUD ecrud = new EscalacaoCRUD();
        Escalacao ready = ecrud.ready(id);
        try {
            ecrud.delete(ready);
            listaEscalacoes = iniciarListaEscalacoes();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage("Erro ao excluir! Verifique se o dado não está dependente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public List<Selecao> getListaSelecoes() {
        return listaSelecoes;
    }

    public void setListaSelecoes(List<Selecao> listaSelecoes) {
        this.listaSelecoes = listaSelecoes;
    }

  
}
