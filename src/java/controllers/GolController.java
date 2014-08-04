/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import crud.GolCRUD;
import crud.JogadorCRUD;
import crud.JogoCRUD;
import crud.OutOfCRUD;
import crud.SelecaoCRUD;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Gol;
import model.Jogador;
import model.Jogo;
import model.Selecao;

/**
 *
 * @author Jéssica Magally
 */
@ManagedBean
public class GolController {

    private Gol gol;
    private List<Jogador> jogadores;
    private List<Selecao> listaSelecao;
    private List<Jogo> listaJogo;
    private Long jogoSelecionado;
    private List<Gol> listaGol;
    private Long jogadorSelecionado;
    private Long selecaoSelecionada;
    private Long jogoFiltroSelecionado;

    public GolController() {
        this.gol = new Gol();
        jogadores = iniciarListaJogadores();
        listaSelecao = iniciarListaSelecao();
        listaJogo = iniciarListaJogo();

    }

    public Long getJogoFiltroSelecionado() {
        return jogoFiltroSelecionado;
    }

    public void setJogoFiltroSelecionado(Long jogoFiltroSelecionado) {
        this.jogoFiltroSelecionado = jogoFiltroSelecionado;
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
        return selecaoSelecionada;
    }

    public void setSelecaoSelecionado(Long selecaoSelecionada) {
        this.selecaoSelecionada = selecaoSelecionada;
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

    public void cadastrarGol() {
        GolCRUD gcrud = new GolCRUD();
        JogadorCRUD jcrud = new JogadorCRUD();
        Jogador j = jcrud.ready(jogadorSelecionado);
        gol.setJogador(j);
        JogoCRUD jocrud = new JogoCRUD();
        Jogo jogo = jocrud.ready(jogoSelecionado);
        gol.setJogo(jogo);
        SelecaoCRUD scrud = new SelecaoCRUD();
        Selecao s = scrud.ready(selecaoSelecionada);
        gol.setSelecao(s);
        gcrud.create(gol);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaGol = iniciarListaGol();
    }

    public void excluirGol(Long id) {
        GolCRUD gcrud = new GolCRUD();
        Gol ready = gcrud.ready(id);
        try {
            gcrud.delete(ready);
            listaGol = iniciarListaGol();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage("Erro ao excluir! Verifique se o dado não está dependente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void filtrarPaisPorJogo() {
        JogoCRUD jcrud = new JogoCRUD();
        Jogo jogo = jcrud.ready(jogoFiltroSelecionado);
        
        OutOfCRUD oocrud = new OutOfCRUD();
        List<Gol> listarGolsPartida = oocrud.listarGolsPartida(jogo);
        listaGol = listarGolsPartida;
    }
    
    public void golMaisRapido() {        
        OutOfCRUD oocrud = new OutOfCRUD();
        Gol golRelampago = oocrud.golRelampago();
        listaGol.clear();
        listaGol.add(gol);
    }

}
