package model.carta;

import model.Jogador;
import control.ControleCasas;

public class CartaReves extends SorteOuReves {

	public CartaReves(int valor) {
		this.valor = valor;
	}

	@Override
	public void acao(Jogador jogador) {
		ControleCasas.getInstance().acao(this, jogador);
	}

}
