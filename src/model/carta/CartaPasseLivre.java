package model.carta;

import model.Jogador;
import model.interfaces.IEfeito;
import control.ControleCasas;

public class CartaPasseLivre implements IEfeito{

	@Override
	public void acao(Jogador jogador) {
		ControleCasas.getInstance().acao(this, jogador);
	}

}
