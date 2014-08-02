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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author suka
 */
@Entity
public class Escalacao implements Serializable {

    private static final long serialVersionUID = -5828902511709270152L;


    @Id
    @GeneratedValue
    private Long ID;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "escalacao_jogador", joinColumns = {
        @JoinColumn(name = "escalação_ID")})
    private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

    @ManyToOne
    private Selecao selecao = new Selecao();

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.ID);
        hash = 67 * hash + Objects.hashCode(this.jogadores);
        hash = 67 * hash + Objects.hashCode(this.selecao);
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
        if (!Objects.equals(this.jogadores, other.jogadores)) {
            return false;
        }
        if (!Objects.equals(this.selecao, other.selecao)) {
            return false;
        }
        return true;
    }
    


    

}
