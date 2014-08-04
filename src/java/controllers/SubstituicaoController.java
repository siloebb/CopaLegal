/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import crud.EscalacaoCRUD;
import crud.JogadorCRUD;
import crud.JogoCRUD;
import crud.OutOfCRUD;
import crud.SelecaoCRUD;
import crud.SubstituicaoCRUD;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Escalacao;
import model.Jogador;
import model.Jogo;
import model.Selecao;
import model.Substituicao;

/**
 *
 * @author Bianca
 */

@ManagedBean
public class SubstituicaoController {
    private Substituicao substituicao;
    private List<Substituicao > listaSubstituicoes;
    
    private List<Selecao> listaSelecoes;
    private Long selecaoSelecionada;
    
     private List<Jogo> listaJogos;
    private Long jogoSelecionado;
    
    private List<Jogador> listaJogadores;
    private Long JogadorSelecionadoSai;
    private Long JogadorSelecionadoEntra;
    
    public SubstituicaoController() {
        listaJogos = iniciarListaJogos();
        listaSelecoes = iniciarListaSelecoes();
        listaJogadores = iniciarListaJogadores();
        this.substituicao = new Substituicao();
        listaSubstituicoes = iniciarListaSubstituicoes();
            }

    public Substituicao getSubstituicao() {
        return substituicao;
    }

    public void setSubstituicao(Substituicao substituicao) {
        this.substituicao = substituicao;
    }

    public List<Substituicao> getListaSubstituicoes() {
        return listaSubstituicoes;
    }

    public void setListaSubstituicoes(List<Substituicao> listaSubstituicoes) {
        this.listaSubstituicoes = listaSubstituicoes;
    }

    public List<Selecao> getListaSelecoes() {
        return listaSelecoes;
    }

    public void setListaSelecoes(List<Selecao> listaSelecoes) {
        this.listaSelecoes = listaSelecoes;
    }

    public Long getSelecaoSelecionada() {
        return selecaoSelecionada;
    }

    public void setSelecaoSelecionada(Long selecaoSelecionada) {
        this.selecaoSelecionada = selecaoSelecionada;
    }

    public List<Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public void setListaJogadores(List<Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

    public Long getJogadorSelecionadoSai() {
        return JogadorSelecionadoSai;
    }

    public void setJogadorSelecionadoSai(Long JogadorSelecionadoSai) {
        this.JogadorSelecionadoSai = JogadorSelecionadoSai;
    }

    public Long getJogadorSelecionadoEntra() {
        return JogadorSelecionadoEntra;
    }

    public void setJogadorSelecionadoEntra(Long JogadorSelecionadoEntra) {
        this.JogadorSelecionadoEntra = JogadorSelecionadoEntra;
    }

    public List<Jogo> getListaJogos() {
        return listaJogos;
    }

    public void setListaJogos(List<Jogo> listaJogos) {
        this.listaJogos = listaJogos;
    }

    public Long getJogoSelecionado() {
        return jogoSelecionado;
    }

    public void setJogoSelecionado(Long jogoSelecionado) {
        this.jogoSelecionado = jogoSelecionado;
    }

    
    public List<Jogador> iniciarListaJogadores(){
       
        
        JogadorCRUD jCrud = new JogadorCRUD();
        List<Jogador> list = jCrud.getList();
        return list;
    }
    
    
     private List<Jogo> iniciarListaJogos() {
       JogoCRUD jCrud = new JogoCRUD();
        List<Jogo> list = jCrud.getList();
        return list;
    }
    
    public List<Selecao> iniciarListaSelecoes(){
        SelecaoCRUD sCrud = new SelecaoCRUD();
        List<Selecao> list = sCrud.getList();
        return list;
    }
    
    private List<Substituicao> iniciarListaSubstituicoes() {
        SubstituicaoCRUD sucrud = new SubstituicaoCRUD();
        List<Substituicao> list = sucrud.getList();
        return list;
    }
    
    
    public void cadastrarSubstituicao() {
        
        
        System.out.println("passo1");
        SelecaoCRUD scrud = new SelecaoCRUD();
        Selecao selecao = scrud.ready(selecaoSelecionada);
        substituicao.setSelecao(selecao);      
        System.out.println("passo2");
       
        JogoCRUD jocrud = new JogoCRUD();
        Jogo jogo = jocrud.ready(jogoSelecionado);
        substituicao.setJogo(jogo);      
        
        JogadorCRUD jcrud = new JogadorCRUD();
        Jogador ready = jcrud.ready(JogadorSelecionadoSai);
        substituicao.setJogadorSaiu(ready);
        
        Jogador read = jcrud.ready(JogadorSelecionadoEntra);
        substituicao.setJogadorEntrou(read);
        
        System.out.println("passo3");
        
        SubstituicaoCRUD sucrud = new SubstituicaoCRUD();

        sucrud.create(substituicao);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaSubstituicoes = iniciarListaSubstituicoes();
    }
    
  public void excluirSubstituicao(Long id) {
        SubstituicaoCRUD ecrud = new SubstituicaoCRUD();
        Substituicao ready = ecrud.ready(id);
        try {
            ecrud.delete(ready);
            listaSubstituicoes = iniciarListaSubstituicoes();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage("Erro ao excluir! Verifique se o dado não está dependente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }  

   
}

