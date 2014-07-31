package controllers;

import crud.CopaCRUD;
import crud.OutOfCRUD;
import crud.PaisCRUD;
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
public class PaisController {

    Pais pais;
    List<Pais> listaPaises;
    List<Copa> listaCopas;
    Long idCopaParaBusca;
    Long copaSelecionada;

    public PaisController() {
        this.pais = new Pais();
        listaPaises = iniciarListaPaises();
        listaCopas = iniciarListaCopa();
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(List<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public Long getIdCopaParaBusca() {
        return idCopaParaBusca;
    }

    public void setIdCopaParaBusca(Long idCopaParaBusca) {
        this.idCopaParaBusca = idCopaParaBusca;
    }

    public Long getCopaSelecionada() {
        return copaSelecionada;
    }

    public void setCopaSelecionada(Long copaSelecionada) {
        this.copaSelecionada = copaSelecionada;
    }

    public List<Copa> getListaCopas() {
        return listaCopas;
    }

    public void setListaCopas(List<Copa> listaCopas) {
        this.listaCopas = listaCopas;
    }
    
    
    

    public void cadastrarPais() {
        PaisCRUD pcrud = new PaisCRUD();
        pcrud.create(pais);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaPaises = iniciarListaPaises();
    }

    public List<Pais> iniciarListaPaises() {
        PaisCRUD pcrud = new PaisCRUD();
        List<Pais> list = pcrud.getList();
        return list;
    }
    
    public List<Copa> iniciarListaCopa(){
        CopaCRUD ccrud = new CopaCRUD();
        return ccrud.getList();
    }

    public void excluirPais(Long id) {
        PaisCRUD pcrud = new PaisCRUD();
        Pais ready = pcrud.ready(id);
        try {
            pcrud.delete(ready);
            listaPaises = iniciarListaPaises();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage("Erro ao excluir! Verifique se o dado não está dependente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    
    public void filtrarPaisPorCopa() {
        CopaCRUD ccrud = new CopaCRUD();
        Copa ready = ccrud.readyByAno(copaSelecionada);
        
        OutOfCRUD oocrud = new OutOfCRUD();
        List<Pais> listarPaisesCopa = oocrud.listarPaisesCopa(ready);
        listaPaises = listarPaisesCopa;
    }

}
