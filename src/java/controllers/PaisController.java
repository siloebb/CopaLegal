

package controllers;

import crud.PaisCRUD;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Pais;

/**
 *
 * @author Siloe
 */
@ManagedBean
public class PaisController {
    
    Pais pais;
    List<Pais> listaPaises;

    public PaisController() {
        this.pais = new Pais();
        listaPaises = iniciarListaPaises();
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
    
    public void cadastrarPais(){
        PaisCRUD pcrud = new PaisCRUD();
        pcrud.create(pais);
        FacesMessage message = new FacesMessage("Cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, message);
        listaPaises = iniciarListaPaises();
    }
    
    public List<Pais> iniciarListaPaises(){
        PaisCRUD pcrud = new PaisCRUD();
        List<Pais> list = pcrud.getList();
        return list;
    }
    
}
