/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity; 
/**
 *
 * @author Bianca
 */
@Entity
public class Jogo implements Serializable{
    private static final long serialVersionUID = -4887476046596007535L;
   
    
    @Id @GeneratedValue
    private Long ID;
    private Integer ano;
    private String data;
    private String local;
    private String horario;
    private Fase fase;

    //Falta implementar o relacionamento quando as demais classes forem adicionadas
    //jogo ocorre entre duas seleções e
    //jogo tem gols 
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.ID);
        hash = 37 * hash + Objects.hashCode(this.ano);
        hash = 37 * hash + Objects.hashCode(this.data);
        hash = 37 * hash + Objects.hashCode(this.local);
        hash = 37 * hash + Objects.hashCode(this.horario);
        hash = 37 * hash + Objects.hashCode(this.fase);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogo other = (Jogo) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (this.fase != other.fase) {
            return false;
        }
        return true;
    }
  
   
}
