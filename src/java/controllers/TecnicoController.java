/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import crud.TecnicoCRUD;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Tecnico;

/**
 *
 * @author Jéssica Magally
 */
@ManagedBean
public class TecnicoController {
    Tecnico tecnico;
    List<Tecnico> listasTecnicos;
    
    public TecnicoController(){
        this.tecnico = new Tecnico();
        listasTecnicos = iniciarListaTecnico();
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public List<Tecnico> getListasTecnicos() {
        return listasTecnicos;
    }

    public void setListasTecnicos(List<Tecnico> listasTecnicos) {
        this.listasTecnicos = listasTecnicos;
    }
    
    
    public void cadastrarTecnico(){
        TecnicoCRUD ccrud = new TecnicoCRUD();    
        ccrud.create(tecnico);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listasTecnicos = iniciarListaTecnico();
        
    }
    
    public void excluirTecnico(Long id) {
        TecnicoCRUD tcrud = new TecnicoCRUD();
        Tecnico ready = tcrud.ready(id);
        try {
            tcrud.delete(ready);
            listasTecnicos = iniciarListaTecnico();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage("Erro ao excluir! Verifique se o dado não está dependente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
       
    
    public List<Tecnico> iniciarListaTecnico(){
        TecnicoCRUD ccrud = new TecnicoCRUD();
        return ccrud.getList();
    }
    
    
}
