/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author suka
 */
@Entity
public class Escalacao implements Serializable{
    
    private static final long serialVersionUID = 7799705139670891224L;
    
    @Id
    @GeneratedValue
    private Long ID;
    
    private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    private Selecao selecao = new Selecao();
    
    public void setArrayJogadores(ArrayList j){
        this.jogadores = j;
          
    }
    public ArrayList<Jogador> getArrayJogadores(){
        return this.jogadores;
    }
    public void setSelecao(Selecao selecao){
        this.selecao = selecao;
    }
    public Selecao getSelecao(){
        return this.selecao;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.ID);
        hash = 47 * hash + Objects.hashCode(this.jogadores);
        hash = 47 * hash + Objects.hashCode(this.selecao);
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
        final Escalacao other = (Escalacao) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.selecao, other.selecao)) {
            return false;
        }
        
        return true;
    }
    public void addJogador(Jogador jogador){
        if(jogadores.size() < 11){
            jogadores.add(jogador);
        }
        
    }
    public void removeJogador(Jogador jogador){
        if(!jogadores.isEmpty()){
            jogadores.remove(jogador);
        }
    }
    
}
