package model.carta;

import model.Jogador;
import control.ControleCasas;


public class CartaSorte extends SorteOuReves{
	
	public CartaSorte(int valor) {
		this.valor =  valor;
	}

	@Override
	public void acao(Jogador jogador) {
		ControleCasas.getInstance().acao(this, jogador);		
	}

}
