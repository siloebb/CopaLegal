/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import crud.CopaCRUD;
import crud.GolCRUD;
import crud.JogadorCRUD;
import crud.JogoCRUD;
import crud.PaisCRUD;
import crud.SelecaoCRUD;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Copa;
import model.Gol;
import model.Jogador;
import model.Jogo;
import model.Pais;
import model.Selecao;

/**
 *
 * @author Jéssica Magally
 */
@ManagedBean
public class GolController {
    Gol gol;
    List<Jogador> jogadores;
    List<Selecao> listaSelecao;
    List<Jogo> listaJogo;
    private Long jogoSelecionado;
    private List<Gol> listaGol;
    private Long jogadorSelecionado;
    private Long selecaoSelecionado;
    
     public GolController() {
        this.gol = new Gol();
        jogadores = iniciarListaJogadores();
        listaSelecao = iniciarListaSelecao();
        listaJogo = iniciarListaJogo();
        
    }

    public Gol getGol() {
        return gol;
    }

    public void setGol(Gol gol) {
        this.gol = gol;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public List<Selecao> getListaSelecao() {
        return listaSelecao;
    }

    public void setListaSelecao(List<Selecao> listaSelecao) {
        this.listaSelecao = listaSelecao;
    }

    public List<Jogo> getListaJogo() {
        return listaJogo;
    }

    public void setListaJogo(List<Jogo> listaJogo) {
        this.listaJogo = listaJogo;
    }

    public Long getJogoSelecionado() {
        return jogoSelecionado;
    }

    public void setJogoSelecionado(Long jogoSelecionado) {
        this.jogoSelecionado = jogoSelecionado;
    }

    public List<Gol> getListaGol() {
        return listaGol;
    }

    public void setListaGol(List<Gol> listaGol) {
        this.listaGol = listaGol;
    }

    public Long getJogadorSelecionado() {
        return jogadorSelecionado;
    }

    public void setJogadorSelecionado(Long jogadorSelecionado) {
        this.jogadorSelecionado = jogadorSelecionado;
    }

    public Long getSelecaoSelecionado() {
        return selecaoSelecionado;
    }

    public void setSelecaoSelecionado(Long selecaoSelecionado) {
        this.selecaoSelecionado = selecaoSelecionado;
    }
         
    
    private List<Gol> iniciarListaGol() {
        GolCRUD gcrud = new GolCRUD();
        List<Gol> list = gcrud.getList();
        return list;
    }
     

    private List<Jogador> iniciarListaJogadores() {
        JogadorCRUD jcrud = new JogadorCRUD();
        List<Jogador> list = jcrud.getList();
        return list;
    }

    private List<Selecao> iniciarListaSelecao() {
        SelecaoCRUD scrud = new SelecaoCRUD();
        List<Selecao> list = scrud.getList();
        return list;
    }

    private List<Jogo> iniciarListaJogo() {
        JogoCRUD jocrud = new JogoCRUD();
        List<Jogo> list = jocrud.getList();
        return list;
       
    }
    
    public void cadastrarCopa(){
        GolCRUD gcrud = new GolCRUD();
        JogadorCRUD jcrud = new JogadorCRUD();
        Jogador j = jcrud.ready(jogadorSelecionado);
        gol.setJogador(j);
        JogoCRUD jocrud = new JogoCRUD();
        Jogo jogo = jocrud.ready(jogoSelecionado);
        gol.setJogo(jogo);
        SelecaoCRUD scrud = new SelecaoCRUD();
        Selecao s = scrud.ready(selecaoSelecionado);
        gol.setSelecao(s);
        gcrud.create(gol);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaGol = iniciarListaGol();
    }
    
}
