
package controllers;

import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Copa;

/**
 *
 * @author Siloe
 */
@ManagedBean
public class EspecialController {
    
    private Long copaSelecionada;
    
    private List<Copa> listaCopa;

    public EspecialController() {
    }
    
    public Long getCopaSelecionada() {
        return copaSelecionada;
    }

    public void setCopaSelecionada(Long copaSelecionada) {
        this.copaSelecionada = copaSelecionada;
    }
    
    
}
