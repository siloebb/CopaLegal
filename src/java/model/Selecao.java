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
 * @author suka
 */
@Entity
public class Selecao implements Serializable{
    
    private static final long serialVersionUID = -5258232343212344645L;
   
    @Id
    @GeneratedValue
    private Long ID;
    private int ano;
    private int posicao;
    private String grupo;
    @ManyToOne
    private Tecnico tecnico;
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Jogador jogador;
    
    public void setPais(Pais pais){
        this.pais = pais;
    }
    public Pais getPais(){
        return this.pais;
    }
    
    public Tecnico getTecnico(){
        return this.tecnico;
    }
    public void setTecnico(Tecnico tecnico){
        this.tecnico = tecnico;
    }
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
    public void setAno(int ano){
        this.ano = ano;
    }
    public int getAno(){
        return this.ano;
    }
    public void setPosicao(int posicao){
        this.posicao = posicao;
    }
    public int getPosicao(){
        return this.posicao;
    }
    public void setGrupo(String grupo){
        this.grupo = grupo;
    }
    public String getGrupo(){
        return this.grupo;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.ID);
        hash = 11 * hash + this.ano;
        hash = 11 * hash + this.posicao;
        hash = 11 * hash + Objects.hashCode(this.grupo);
        hash = 11 * hash + Objects.hashCode(this.tecnico);
        hash = 11 * hash + Objects.hashCode(this.pais);
        return hash;
    }
    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (getClass() != objeto.getClass()) {
            return false;
        }
        final Selecao other = (Selecao) objeto;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.grupo, other.grupo)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.tecnico, other.tecnico)) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (this.posicao != other.posicao) {
            return false;
        }
        return true;
    }
    
}
