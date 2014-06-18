/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author Jéssica Magally
 */
@Entity
public class Tecnico implements Serializable {
    @Id
    private String nome;
    private String dataNascimento;
    
    //private Selecao selecao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /*public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }*/
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tecnico other = (Tecnico) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        /*if (!Objects.equals(this.selecao, other.selecao)) {
            return false;
        }*/
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.dataNascimento);
       // hash = 71 * hash + Objects.hashCode(this.selecao);
        return hash;
    }
}
