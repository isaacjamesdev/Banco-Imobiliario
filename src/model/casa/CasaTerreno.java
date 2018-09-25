package model.casa;

import java.awt.Point;

import control.ControleCasas;
import model.Jogador;

public class CasaTerreno extends Propriedade {

	public CasaTerreno(int i, String descricao, int valor, int pedagio, Point coordenada) {
		super(i, descricao, valor, pedagio, coordenada);
		
		// TODO Auto-generated constructor stub
	}

	private int casas;

	public int getCasas() {
		return casas;
	}

	public void setCasas(int casas) {
		this.casas = casas;
	}

	@Override
	public void acao(Jogador jogador) {
		ControleCasas.getInstance().acao(this, jogador);
	}

	@Override
	public int getPedagio() {
		return pedagio;
	}

	@Override
	public int getPedagio(int dados) {
		// TODO Auto-generated method stub
		return 0;
	}

}
