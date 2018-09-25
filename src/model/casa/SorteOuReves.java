package model.casa;

import java.awt.Point;

import dao.DaoCarta;
import model.Jogador;

public class SorteOuReves extends CasaTabuleiro{

	public SorteOuReves(int i, String descricao, Point coordenada) {
		super(i, descricao, coordenada);
	}

	@Override
	public void acao(Jogador jogador) {
		DaoCarta.getInstance().proximaCarta().acao(jogador);
	}

}
