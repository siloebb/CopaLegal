/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
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
    private Copa copa;
    @ManyToMany
    @JoinTable(name="selecao_jogador", joinColumns={@JoinColumn(name="selecao_ID")})
    private List<Jogador> jogador;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Copa getCopa() {
        return copa;
    }

    public void setCopa(Copa copa) {
        this.copa = copa;
    }

    public List<Jogador> getJogador() {
        return jogador;
    }

    public void setJogador(List<Jogador> jogador) {
        this.jogador = jogador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.ID);
        hash = 61 * hash + this.ano;
        hash = 61 * hash + this.posicao;
        hash = 61 * hash + Objects.hashCode(this.grupo);
        hash = 61 * hash + Objects.hashCode(this.tecnico);
        hash = 61 * hash + Objects.hashCode(this.pais);
        hash = 61 * hash + Objects.hashCode(this.copa);
        hash = 61 * hash + Objects.hashCode(this.jogador);
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
        final Selecao other = (Selecao) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (this.posicao != other.posicao) {
            return false;
        }
        if (!Objects.equals(this.grupo, other.grupo)) {
            return false;
        }
        if (!Objects.equals(this.tecnico, other.tecnico)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.copa, other.copa)) {
            return false;
        }
        if (!Objects.equals(this.jogador, other.jogador)) {
            return false;
        }
        return true;
    }

    
    
}
