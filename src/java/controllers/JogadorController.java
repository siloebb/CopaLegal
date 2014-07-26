/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import crud.JogadorCRUD;
import crud.PaisCRUD;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Jogador;
import model.Pais;

/**
 *
 * @author Jéssica Magally
 */
@ManagedBean
public class JogadorController {
    Jogador jogador;
    List<Jogador> listaJogadores;

    public JogadorController() {
        this.jogador = new Jogador();
        listaJogadores = iniciarListaJogadores();
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
    
    public void cadastrarPais() {
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
    
    
}
