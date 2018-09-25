package model.casa;

import java.awt.Point;

import model.Jogador;
import control.ControleCasas;

public class CasaParadaLivre extends CasaTabuleiro {

	public CasaParadaLivre(int i, String descricao, Point coordenada) {
		super(i, descricao, coordenada);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acao(Jogador jogador) {
		ControleCasas.getInstance().acao(this, jogador);
	}

}
