package model.casa;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.Jogador;
import model.interfaces.IJogador;
import control.ControleCasas;

public class CasaPrisao extends CasaTabuleiro {

	public List<IJogador> getPresos() {
		return presos;
	}

	public static CasaPrisao getPrisao() {
		return prisao;
	}

	private List<IJogador> presos;
	private static CasaPrisao prisao;
	
	private CasaPrisao(int i, String descricao, Point coordenada) {
		super(i, descricao, coordenada);
		presos = new ArrayList<IJogador>();
	}
	
	public static CasaPrisao getInstance(){
		return prisao;
	}
	
	public static CasaPrisao getInstance(int i, String descricao, Point coordenada){
		if(prisao == null)
			prisao = new CasaPrisao(i, descricao, coordenada);
		return prisao;
	}
	
	@Override
	public void acao(Jogador jogador) {
		ControleCasas.getInstance().acao(this, jogador);
	}
}