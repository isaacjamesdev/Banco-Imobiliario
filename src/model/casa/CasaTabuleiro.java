package model.casa;

import java.awt.Point;

import model.interfaces.IEfeito;

public abstract class CasaTabuleiro implements IEfeito{
	
	private String descricao;
	private Point coordenada;			
	private int indice;
	public CasaTabuleiro(int i, String descricao, Point coordenada) {
		this.descricao = descricao;
		this.coordenada = coordenada;
		indice = i;
	}
	

	public Point getCoordenada() {
		return coordenada;
	}

	public String getDescricao() {
		return descricao;
	}


	public int getIndice() {
		return indice;
	}
	
	

}
