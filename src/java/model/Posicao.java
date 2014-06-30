/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Bianca
 */
public enum Posicao {
    GOLEIRO(1), ZAGUEIRO(2), LATERAL(3), MEIOCAMPO(4), ATACANTE(5);
	
	private final int valor;
	Posicao(int valorOpcao){
		valor = valorOpcao;
	}
	public int getValor(){
		return valor;
	}
}
