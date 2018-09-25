package model.casa;

import java.awt.Point;

import model.Jogador;

public abstract class Propriedade extends CasaTabuleiro{
	private int valor;
	protected int pedagio;
	protected Jogador dono;
	
	public Propriedade(int i, String descricao, int valor, int pedagio, Point coordenada) {
		super(i, descricao, coordenada);
		this.valor = valor;
		this.pedagio = pedagio;
		dono = null;
	}

	public abstract int getPedagio();
	
	public abstract int getPedagio(int dados);

	public boolean temDono(){
		if(dono == null)
			return false;
		return true;
	}

	public Jogador getDono() {
		return dono;
	}

	public void setDono(Jogador dono) {
		this.dono = dono;
	}
	
	public int getValor() {
		return valor;
	}
}