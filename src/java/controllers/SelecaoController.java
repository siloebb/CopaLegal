/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import crud.CopaCRUD;
import crud.JogadorCRUD;
import crud.PaisCRUD;
import crud.SelecaoCRUD;
import crud.TecnicoCRUD;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Copa;
import model.Jogador;
import model.Pais;
import model.Selecao;
import model.Tecnico;

/**
 *
 * @author suka
 */
@ManagedBean
public class SelecaoController {
    private Selecao selecao ;
    private List<Pais> listaPaises;
    private Long paisSelecionado;
    private List<Tecnico> listaTecnico;
    private Long tecnicoSelecionado;
    private Long copaSelecionada;
    private List<Copa> listaCopa;
    private List<Jogador> listaJogadores;
    private List<Long> listaJogadorSelecionado1;
    private List<Selecao> listaSelecao;
    
    public SelecaoController(){
        selecao = new Selecao();
        listaPaises = iniciarListaPaises();
        listaTecnico = iniciarListaTecnico();
        listaCopa = iniciarListaCopa();
        listaJogadores = iniciarListaJogadores();
        listaSelecao = iniciarListaSelecao();
        listaJogadorSelecionado1 = new ArrayList<Long>();
        
    }

    public Long getPaisSelecionado() {
        return paisSelecionado;
    }

    public void setPaisSelecionado(Long paisSelecionado) {
        this.paisSelecionado = paisSelecionado;
    }

    public Long getTecnicoSelecionado() {
        return tecnicoSelecionado;
    }

    public void setTecnicoSelecionado(Long tecnicoSelecionado) {
        this.tecnicoSelecionado = tecnicoSelecionado;
    }

    public Long getCopaSelecionada() {
        return copaSelecionada;
    }

    public void setCopaSelecionada(Long copaSelecionada) {
        this.copaSelecionada = copaSelecionada;
    }

    
    public List<Selecao> getListaSelecao() {
        return listaSelecao;
    }

    public void setListaSelecao(List<Selecao> listaSelecao) {
        this.listaSelecao = listaSelecao;
    }
  
    

    public List<Long> getListaJogadorSelecionado1() {
        return listaJogadorSelecionado1;
    }

    public void setListaJogadorSelecionado1(List<Long> listaJogadorSelecionado1) {
        this.listaJogadorSelecionado1 = listaJogadorSelecionado1;
    }

    public void cadastrarSelecao(){
        System.out.println("passo1");
        TecnicoCRUD tcrud = new TecnicoCRUD();
        Tecnico tecnico = tcrud.ready(tecnicoSelecionado);
        selecao.setTecnico(tecnico);
        System.out.println("passo2");
        PaisCRUD pcrud = new PaisCRUD();
        Pais pais = pcrud.ready(paisSelecionado);
        selecao.setPais(pais);
        System.out.println("passo3");
        CopaCRUD ccrud = new CopaCRUD();
        Copa copa = ccrud.readyByAno(copaSelecionada);
        selecao.setCopa(copa);
        System.out.println("passo4");
        ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
        JogadorCRUD jcrud = new JogadorCRUD();
        for(int i=0;i<listaJogadorSelecionado1.size();i++){
            Long get =Long.parseLong( "" + listaJogadorSelecionado1.get(i));
            System.out.println("passo4.5");
            Jogador ready = jcrud.ready(get);
            listaJogadores.add(ready);
        }
        selecao.setJogador(listaJogadores);
        System.out.println("passo5");
        SelecaoCRUD scrud = new SelecaoCRUD();
        scrud.create(selecao);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaSelecao = iniciarListaSelecao();
    }

   

    public List<Copa> getListaCopa() {
        return listaCopa;
    }

    public List<Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public void setListaJogadores(List<Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

    public void setListaCopa(List<Copa> listaCopa) {
        this.listaCopa = listaCopa;
    }

    

    public List<Tecnico> getListaTecnico() {
        return listaTecnico;
    }

    public void setListaTecnico(List<Tecnico> listaTecnico) {
        this.listaTecnico = listaTecnico;
    }
    public void excluirSelecao(Long id){
        SelecaoCRUD scrud =new SelecaoCRUD();
        Selecao ready = scrud.ready(id);
        try{
            scrud.delete(ready);
        }catch(Exception ex){
            FacesMessage message = new FacesMessage("Erro ao excluir! Verifique se o dado não está dependente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listaSelecao = iniciarListaSelecao();
    }
    

    
    public List<Tecnico> iniciarListaTecnico(){
        TecnicoCRUD tCrud = new TecnicoCRUD();
        List<Tecnico> list = tCrud.getList();
        return list;
    }
    public List<Jogador> iniciarListaJogadores(){
        JogadorCRUD jCrud = new JogadorCRUD();
        List<Jogador> list = jCrud.getList();
        return list;
    }
    public List<Pais> iniciarListaPaises(){
        PaisCRUD pCrud = new PaisCRUD();
        List<Pais> list = pCrud.getList();
        return list;
    }
    public List<Copa> iniciarListaCopa(){
        CopaCRUD cCrud = new CopaCRUD();
        List<Copa> list = cCrud.getList();
        return list;
    }
    public List<Selecao> iniciarListaSelecao(){
        SelecaoCRUD sCrud = new SelecaoCRUD();
        List<Selecao> list = sCrud.getList();
        return list;
    }

    public List<Pais> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(List<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }
}
