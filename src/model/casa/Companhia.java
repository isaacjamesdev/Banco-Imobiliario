package model.casa;

import java.awt.Point;

import model.Jogador;
import control.ControleCasas;

public class Companhia extends Propriedade {

	public Companhia(int i, String descricao, int valor, int pedagio, Point coordenada) {
		super(i, descricao, valor, pedagio, coordenada);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPedagio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPedagio(int dados) {
		return pedagio*dados;
	}

	@Override
	public void acao(Jogador jogador) {
		ControleCasas.getInstance().acao(this, jogador);		
	}

}
