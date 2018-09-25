package control;

import javax.swing.JOptionPane;

import model.Jogador;
import model.casa.Propriedade;
import model.interfaces.IControleJogada;
import view.Som;
import view.ViewBemVindo;
import dao.DaoJogador;
import dao.DaoTabuleiro;
import dao.IteratorJogador;

public class ControleJogo implements IControleJogada, IteratorJogador{
	
	private static ControleJogo controleJogo;
	public ControleJogo() {
		// TODO Auto-generated constructor stub
	}
	
	public static ControleJogo getInstance(){
		if(controleJogo == null)
			controleJogo = new ControleJogo();
		return controleJogo;
	}

	@Override
	public void inicarJogo() {
		DaoTabuleiro.getInstance();
		//CADASTRO JOGADOR
		cadastrarJogador("Pino1.png");
		cadastrarJogador("Pino2.png");
		JOptionPane.showMessageDialog(null, ControleJogador.getInstace().getJogador1().getNome()+" - Pino Preto\n"+
				ControleJogador.getInstace().getJogador2().getNome()+" - Pino Laranja\n");
		//----------
		//TELA DE BEM VINDO
		ViewBemVindo.getInstance().telaBemVindo();		
		
	}
	
	@Override
	public void proximaRodada(Jogador jogador) {
		JOptionPane.showMessageDialog(null,jogador.getNome()+". Sua vez");
		if(verificaSeJogadorEstarPreso(jogador)){
			fluxoTapreso(jogador);
		}else{
			lancarDados();
			moverJogador(jogador, ControleDado.getInstance().getValorDados());	
		}
	}
	
	private void fluxoTapreso(Jogador jogador) {
		JOptionPane.showMessageDialog(null, jogador.getNome()+", voce esta preso. tenta a sorte nos dados");
		if(jogador.getRegistroPrisao() < 3){
			lancarDados();
			if(ControleDado.getInstance().dadosIguais())
				removerDaPrisao(jogador);
		}else
			pagarFianca(jogador, 50);
	}

	public void moverJogador(Jogador jogador, int dados){
		ControleJogador.getInstace().moverJogador(jogador, dados);
	}
	
	@Override
	public Jogador proximoJogador(Jogador jogador) {
		if (jogador == DaoJogador.getInstance().getJogadores().get(0))
			return (Jogador) DaoJogador.getInstance().getJogadores().get(1);
		else 
			return (Jogador) DaoJogador.getInstance().getJogadores().get(0);
	}
		
	@Override
	public void cadastrarJogador(String pino) {
		DaoJogador.getInstance().cadastrarJogador(
				new Jogador(JOptionPane.showInputDialog("Digite seu nome"), pino));
	}

	@Override
	public boolean verificaSeJogadorEstarPreso(Jogador jogador) {
		return ControleJogador.getInstace().isPreso(jogador);
	}

	@Override
	public boolean verificaSeJogadorJogouTresVezes(Jogador jogador) {
		if(ControleJogador.getInstace().getRegistroPrisao(jogador) <=2)
				return false;
		return true;
	}
	
	@Override
	public int lancarDados() {
		return ControleDado.getInstance().lancarDados();
	}

	@Override
	public boolean verificaDadosIguais(Jogador jogador) {
		if(ControleDado.getInstance().dadosIguais()){
			jogador.setRegistroDados();
			return true;
		}
		return false;
		
	}

	@Override
	public boolean verificaSeTaRoubando(Jogador jogador) {
		if(ControleJogador.getInstace().getRegistroDados(jogador) >= 3)
			return true;
		return false;
	}

	@Override
	public void pagarFianca(Jogador jogador, int valor) {
		ControleJogador.getInstace().pagarTaxa(jogador, valor);
		Som.playCash();
		removerDaPrisao(jogador);
		ControleJogador.getInstace().zeraRegistroPrisao(jogador);
	}

	@Override
	public void removerDaPrisao(Jogador jogador) {
		ControlePrisao.getInstance().removerPreso(jogador);
		ControleJogador.getInstace().zeraRegistroPrisao(jogador);
		ControleJogador.getInstace().tornarSolto(jogador);
	}

	@Override
	public void moverParaPrisao(Jogador jogador) {
		ControlePrisao.getInstance().adicionarPreso(jogador);
		ControleJogador.getInstace().tornarPreso(jogador);
		ControleJogador.getInstace().moverPrisao(jogador);
	}


	@Override
	public void comprarPropriedade(Propriedade propriedade, Jogador jogador) {
		ControleJogador.getInstace().comprarPropriedade(jogador, propriedade);
	}

	@Override
	public boolean verificaDinheiro(Jogador jogador, int valor) {
		return ControleJogador.getInstace().verificaDinheiro(jogador, valor);
	}

	@Override
	public void removerJogador(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}

	public void Mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
