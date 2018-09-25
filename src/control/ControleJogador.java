package control;

import model.Jogador;
import model.casa.Propriedade;
import dao.DaoJogador;
import dao.DaoTabuleiro;

public class ControleJogador{
	
	private static ControleJogador controleJogador;
	
	public static ControleJogador getInstace(){
		if(controleJogador == null)
			controleJogador = new ControleJogador();
		return controleJogador;
	}
	private ControleJogador(){		
	}
	
	public void cadastrarJogador(String nome, String img){
		DaoJogador.getInstance().cadastrarJogador(new Jogador(nome, img));
	}
	
	public void removerJogador(Jogador jogador){
		DaoJogador.getInstance().removerJogador(jogador);
	}

	public void comprarPropriedade(Jogador jogador, Propriedade propriedade) {
		jogador.comprarPropriedade(propriedade);
	}

	public void pagarTaxa(Jogador jogador, int valor) {
		jogador.pagarTaxa(valor);
	}

	public void receberTaxa(Jogador jogador, int valor) {
		jogador.receberTaxa(valor);
	}
	
	public boolean isPreso(Jogador jogador){
		return jogador.isPreso();
	}
	
	public void tornarPreso(Jogador jogador){
		jogador.setPreso(true);
	}
	
	public void tornarSolto(Jogador jogador){
		jogador.setPreso(false);
	}
	
	public boolean verificaDinheiro(Jogador jogador, int valor){
		if(jogador.getDinheiro() < valor)
			return false;
		return true;
	}
	
	public int getRegistroPrisao(Jogador jogador) {
		return jogador.getRegistroPrisao();
	}

	public void setRegistroPrisao(Jogador jogador) {
		jogador.setRegistroPrisao();
	}
	
	public void zeraRegistroPrisao(Jogador jogador){
		jogador.zeraRegistroPrisao();
	}
		
	public int getRegistroDados(Jogador jogador) {
		return jogador.getRegistroDados();
	}

	public void setRegistroDados(Jogador jogador) {
		jogador.setRegistroDados();
	}
	
	public void zeraRegistroDados(Jogador jogador){
		jogador.zeraRegistroDados();
	}

	public void moverJogador(Jogador jogador, int dados){
		int destino = ((jogador.getCasaAtual().getIndice()+dados)%40);
		jogador.setCasaAtual(DaoTabuleiro.getInstance().getCasas().get(destino));
	}
	
	public void moverPrisao(Jogador jogador){
		jogador.setCasaAtual(DaoTabuleiro.getInstance().getCasas().get(10));
	}
	
	
	public Jogador getJogador1(){
		return (Jogador) DaoJogador.getInstance().getJogadores().get(0);
	}
	
	public Jogador getJogador2(){
		return (Jogador) DaoJogador.getInstance().getJogadores().get(1);
	}

}
