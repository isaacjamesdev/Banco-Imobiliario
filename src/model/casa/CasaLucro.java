package model.casa;

import java.awt.Point;

import model.Jogador;
import control.ControleCasas;

public class CasaLucro extends CasaTabuleiro{
	
	private int valor;

	public CasaLucro(int i, String descricao, int valor, Point coordenada) {
		super(i, descricao, coordenada);
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public void acao(Jogador jogador) {
		ControleCasas.getInstance().acao(this, jogador);
	}

}
