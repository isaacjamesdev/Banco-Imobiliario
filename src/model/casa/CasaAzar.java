package model.casa;

import java.awt.Point;

import model.Jogador;
import control.ControleCasas;

public class CasaAzar extends CasaTabuleiro {

	private int valor;

	public int getValor() {
		return valor;
	}

	public CasaAzar(int i, String descricao, int valor, Point coordenada) {
		super(i, descricao, coordenada);
		this.valor = valor;
		// TODO Auto-generated constructor stub
	}

	// @Override
	public void acao(Jogador jogador) {
		ControleCasas.getInstance().acao(this, jogador);
	}

}
