package dao;

import java.util.ArrayList;
import java.util.List;

import model.Jogador;

public class DaoJogador {

	private List<Jogador> jogadores;
	private static DaoJogador daoJogador;

	private DaoJogador() {
		jogadores = new ArrayList<>();
	}

	public static DaoJogador getInstance() {
		if (daoJogador == null)
			daoJogador = new DaoJogador();
		return daoJogador;
	}

	public void cadastrarJogador(Jogador jogador) {
		jogadores.add(jogador);
	}

	public void removerJogador(Jogador jogador) {
		jogadores.remove(jogador);
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}
}
