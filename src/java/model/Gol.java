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
import javax.persistence.OneToOne;

/**
 *
 * @author Jéssica Magally
 */
@Entity
public class Gol implements Serializable {

    private static final long serialVersionUID = -2907254920271989355L;

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Jogador jogador;
    @ManyToOne
    private Jogo jogo;
    private Long tempo;
    private boolean foiContra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Long getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
        this.tempo = tempo;
    }

    public boolean isFoiContra() {
        return foiContra;
    }

    public void setFoiContra(boolean foiContra) {
        this.foiContra = foiContra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.jogador);
        hash = 29 * hash + Objects.hashCode(this.jogo);
        hash = 29 * hash + Objects.hashCode(this.tempo);
        hash = 29 * hash + (this.foiContra ? 1 : 0);
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
        final Gol other = (Gol) obj;
        if (!Objects.equals(this.jogador, other.jogador)) {
            return false;
        }
        if (!Objects.equals(this.jogo, other.jogo)) {
            return false;
        }
        if (!Objects.equals(this.tempo, other.tempo)) {
            return false;
        }
        if (this.foiContra != other.foiContra) {
            return false;
        }
        return true;
    }

}
