
package controllers;

import crud.CopaCRUD;
import crud.PaisCRUD;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Copa;
import model.Pais;

/**
 *
 * @author Siloe
 */
@ManagedBean
public class CopaController {
    
    Copa copa;
    Long paisSelecionado;
    List<Pais> paises;
    List<Copa> listaCopas;

    public CopaController() {
        this.copa = new Copa();
        paises = iniciarListaPaises();
        listaCopas = iniciarListaCopa();
    }

    public Copa getCopa() {
        return copa;
    }

    public void setCopa(Copa copa) {
        this.copa = copa;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public List<Copa> getListaCopas() {
        return listaCopas;
    }

    public void setListaCopas(List<Copa> listaCopas) {
        this.listaCopas = listaCopas;
    }

    public Long getPaisSelecionado() {
        return paisSelecionado;
    }

    public void setPaisSelecionado(Long paisSelecionado) {
        this.paisSelecionado = paisSelecionado;
    }
    
    public List<Pais> iniciarListaPaises(){
        PaisCRUD pcrud = new PaisCRUD();
        List<Pais> list = pcrud.getList();
        return list;
    }
    
    public List<Copa> iniciarListaCopa(){
        CopaCRUD ccrud = new CopaCRUD();
        return ccrud.getList();
    }
    
    public void cadastrarCopa(){
        CopaCRUD ccrud = new CopaCRUD();
        PaisCRUD pcrud = new PaisCRUD();
        Pais p = pcrud.ready(paisSelecionado);
        copa.setPais(p);
        ccrud.create(copa);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaCopas = iniciarListaCopa();
    }
    
    public void excluirCopa(int ano) {
        CopaCRUD pcrud = new CopaCRUD();
        Copa ready = pcrud.ready(ano);
        try {
            pcrud.delete(ready);
            listaCopas = iniciarListaCopa();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage("Erro ao excluir! Verifique se o dado não está dependente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
}
