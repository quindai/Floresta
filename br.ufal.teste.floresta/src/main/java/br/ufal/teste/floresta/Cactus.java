package br.ufal.teste.floresta;

import java.awt.Dimension;

public class Cactus extends Vegetacao{
	public Cactus(Dimension a){
		super(a, "cactus.png");
		nome = "Cactus";
		toxicidade = (int)(Math.random() * 2) ;
	}
	
	/*private String getToxicidadeNome(){
		String saida = "";
		switch (toxicidade) {
		case 0:
			saida = "";
			break;
		case 1:
			saida = tipoToxicidade.TOXICO.name();
		default:
			saida = tipoToxicidade.MUITO_TOXICO.name();
		}
		return saida;
	}*/
	public String toString(){
		return String.format("%s %s", super.toString(), getToxicidadeNome());
	}
}
