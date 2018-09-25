package model.interfaces;

import model.Jogador;
import model.casa.Propriedade;

public interface IControleJogada{
	
	public void inicarJogo();
	public void proximaRodada(Jogador jogador);
	public boolean verificaSeJogadorEstarPreso(Jogador jogador);
	public boolean verificaSeJogadorJogouTresVezes(Jogador jogador);
	public int lancarDados();
	public boolean verificaDadosIguais(Jogador jogador);
	public boolean verificaSeTaRoubando(Jogador jogador);
	public void pagarFianca(Jogador jogador, int valor);
	public void removerDaPrisao(Jogador jogador);
	public void moverParaPrisao(Jogador jogador);
	public void comprarPropriedade(Propriedade propriedade, Jogador jogador);
	public boolean verificaDinheiro(Jogador jogador, int valor);
	public void removerJogador(Jogador jogador);
	void cadastrarJogador(String pino);
	
//	viu
	

}
