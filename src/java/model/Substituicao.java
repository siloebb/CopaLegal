
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Siloe
 */
@Entity
public class Substituicao implements Serializable{
    
    private static final long serialVersionUID = 751446445445143711L;
    
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Selecao selecao;
    private Long tempo;
    @ManyToOne
    private Jogador jogadorEntrou;
    @ManyToOne
    private Jogador jogadorSaiu;
    @ManyToOne
    private Jogo jogo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }

    public Long getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
        this.tempo = tempo;
    }

    public Jogador getJogadorEntrou() {
        return jogadorEntrou;
    }

    public void setJogadorEntrou(Jogador jogadorEntrou) {
        this.jogadorEntrou = jogadorEntrou;
    }

    public Jogador getJogadorSaiu() {
        return jogadorSaiu;
    }

    public void setJogadorSaiu(Jogador jogadorSaiu) {
        this.jogadorSaiu = jogadorSaiu;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.selecao);
        hash = 47 * hash + Objects.hashCode(this.tempo);
        hash = 47 * hash + Objects.hashCode(this.jogadorEntrou);
        hash = 47 * hash + Objects.hashCode(this.jogadorSaiu);
        hash = 47 * hash + Objects.hashCode(this.jogo);
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
        final Substituicao other = (Substituicao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.selecao, other.selecao)) {
            return false;
        }
        if (!Objects.equals(this.tempo, other.tempo)) {
            return false;
        }
        if (!Objects.equals(this.jogadorEntrou, other.jogadorEntrou)) {
            return false;
        }
        if (!Objects.equals(this.jogadorSaiu, other.jogadorSaiu)) {
            return false;
        }
        if (!Objects.equals(this.jogo, other.jogo)) {
            return false;
        }
        return true;
    }
    
    
}
