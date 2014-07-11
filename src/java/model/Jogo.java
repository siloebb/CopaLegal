/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id; 
import javax.persistence.ManyToOne; 
/**
 *
 * @author Bianca
 */
@Entity
public class Jogo implements Serializable{
    private static final long serialVersionUID = -9050116611619577962L;
       

    
    @Id @GeneratedValue
    private Long ID;
    private Integer ano;
    private String data;
    private String local;
    private String horario;
    private Fase fase;
    
    @ManyToOne
    private Selecao s1;
    @ManyToOne
    private Selecao s2;


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


    public Selecao getS1() {
        return s1;
    }

    public void setS1(Selecao s1) {
        this.s1 = s1;
    }

    public Selecao getS2() {
        return s2;
    }

    public void setS2(Selecao s2) {
        this.s2 = s2;
    }


    @Override
    public int hashCode() {
        int hash = 7;

        hash = 79 * hash + Objects.hashCode(this.ID);
        hash = 79 * hash + Objects.hashCode(this.ano);
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + Objects.hashCode(this.local);
        hash = 79 * hash + Objects.hashCode(this.horario);
        hash = 79 * hash + Objects.hashCode(this.fase);
        hash = 79 * hash + Objects.hashCode(this.s1);
        hash = 79 * hash + Objects.hashCode(this.s2);

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

        if (!Objects.equals(this.s1, other.s1)) {
            return false;
        }
        if (!Objects.equals(this.s2, other.s2)) {
            return false;
        }

        return true;
    }
   
}
