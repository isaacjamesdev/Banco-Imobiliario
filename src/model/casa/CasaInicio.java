package model.casa;

import java.awt.Point;

import control.ControleJogador;
import model.Jogador;

public class CasaInicio extends CasaTabuleiro{
	private int valor;
	
	public int getValor() {
		return valor;
	}

	public CasaInicio(int i, String descricao, int valor, Point coordenada) {
		super(i,descricao, coordenada);
		this.valor = valor;
	}

	@Override
	public void acao(Jogador jogador) {
		ControleJogador.getInstace().receberTaxa(jogador, valor);
	}
	
}
