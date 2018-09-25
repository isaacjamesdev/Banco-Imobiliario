package view;

import javax.swing.JOptionPane;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;
import model.Jogador;
import model.casa.CasaTabuleiro;
import model.dado.Dado;
import control.ControleDado;
import control.ControleJogador;
import control.ControleJogo;

public class ViewJogo {
	private Window janela;
	private Scene scena;
	private static Keyboard teclado;
	Jogador jogador = ControleJogador.getInstace().getJogador1();
	private Jogador jogadorAtual;

	public ViewJogo(Window janela) {
		scena = new Scene();
		this.janela = janela;
		janela.setSize(700, 700);
		scena.loadFromFile(URL.scenario("tabuleito.scn"));
		teclado = janela.getKeyboard();
		setJogadorAtual(ControleJogador.getInstace().getJogador1());
		run();
	}

	public void run() {
		janela.update();
		while (true) {
			janela.update();
			scena.draw();
			janela.update();
			janela.delay(10);
			ControleJogador.getInstace().getJogador1().getPino().draw();
			ControleJogador.getInstace().getJogador2().getPino().draw();
			
			updateJanela();
			ControleJogo.getInstance().proximaRodada(jogador);
			desenhaDado();
			updateJanela();

			jogador.getCasaAtual().acao(jogador);
			updateJanela();
			fluxoDadosIguais();

			jogador = ControleJogo.getInstance().proximoJogador(jogador);
			updateJanela();
		}

	}

	public void fluxoDadosIguais() {
		if (ControleDado.getInstance().dadosIguais()) {
			if (ControleJogo.getInstance().verificaSeTaRoubando(jogador)) {
				JOptionPane.showMessageDialog(null,
						"Você viciou os dados.\nVÁ PARA PRISÃO");
				jogador.zeraRegistroDados();
			}
			jogador.setRegistroDados();
			ControleJogo.getInstance().proximaRodada(jogador);
		}
	}

	public void updateJanela() {
		janela.update();

	}

	public void proximaRodada() {
		while (true) {
			if (teclado.keyDown(Keyboard.ENTER_KEY)) {
				janela.setSize(700, 700);
			}
		}
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void desenhaDado() {
		for (Dado d : ControleDado.getInstance().getDados()) {
			d.getImagemDado().draw();
			janela.update();
		}
		JOptionPane.showMessageDialog(null, "Resultado dos dados: "
				+ ControleDado.getInstance().getValorDados());
	}

	public void desenhaCasaDescricao(CasaTabuleiro casa) {
		JOptionPane.showMessageDialog(null, casa.getDescricao());
	}

	public void moverJogador(Pino pino, Jogador jogador) {
		pino.draw();
		pino.moveTo(jogador.getCoordenada().getX(), jogador.getCoordenada()
				.getY(), 0.5);
	}

	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}

	public void setJogadorAtual(Jogador jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}
}
