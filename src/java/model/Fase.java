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
public enum Fase {
    
	PRIMEIRA(1), OITAVAS(2), QUARTAS(3), SEMIFINAL(4), FINAL(5);
	
	private final int valor;
	Fase(int valorOpcao){
		valor = valorOpcao;
	}
	public int getValor(){
		return valor;
	}

}
