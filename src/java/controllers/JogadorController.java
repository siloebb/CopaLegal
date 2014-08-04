/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import crud.JogadorCRUD;
import crud.OutOfCRUD;
import crud.SelecaoCRUD;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Jogador;
import model.Selecao;

/**
 *
 * @author Jéssica Magally
 */
@ManagedBean
public class JogadorController {
    private Jogador jogador;
    private List<Jogador> listaJogadores;
    private List<Selecao> listaSelecao;
    private Long selecaoSelecionada;

    public JogadorController() {
        this.jogador = new Jogador();
        listaJogadores = iniciarListaJogadores();
        listaSelecao = iniciarListaSelecao();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public List<Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public void setListaJogadores(List<Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

    public List<Selecao> getListaSelecao() {
        return listaSelecao;
    }

    public void setListaSelecao(List<Selecao> listaSelecao) {
        this.listaSelecao = listaSelecao;
    }

    public Long getSelecaoSelecionada() {
        return selecaoSelecionada;
    }

    public void setSelecaoSelecionada(Long selecaoSelecionada) {
        this.selecaoSelecionada = selecaoSelecionada;
    }
    
    public void cadastrarJogador() {
        JogadorCRUD jcrud = new JogadorCRUD();
        jcrud.create(jogador);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaJogadores = iniciarListaJogadores();
    }
    private List<Jogador> iniciarListaJogadores() {
        JogadorCRUD jcrud = new JogadorCRUD();
        List<Jogador> list = jcrud.getList();
        return list;
    }
    
    public List<Selecao> iniciarListaSelecao(){
        SelecaoCRUD sCrud = new SelecaoCRUD();
        List<Selecao> list = sCrud.getList();
        return list;
    }
    
    public void excluirJogador(Long id) {
        JogadorCRUD jcrud = new JogadorCRUD();
        Jogador ready = jcrud.ready(id);
        try {
            jcrud.delete(ready);
            listaJogadores = iniciarListaJogadores();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage("Erro ao excluir! Verifique se o dado não está dependente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void listarPorSelecao(){
        SelecaoCRUD scrud = new SelecaoCRUD();
        Selecao ready = scrud.ready(selecaoSelecionada);
        OutOfCRUD oocrud = new OutOfCRUD();
        List<Jogador> listarJogadoresSelecao = oocrud.listarJogadoresSelecao(ready);
        listaJogadores = listarJogadoresSelecao;
    }
    
    
}
