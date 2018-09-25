package model.casa;

import java.awt.Point;

import javax.swing.JOptionPane;

import model.Jogador;
import control.ControleJogador;
import control.ControleJogo;
import control.ControlePrisao;

public class CasaVaParaPrisao extends CasaTabuleiro{

	public CasaVaParaPrisao(int i, String descricao, Point coordenada) {
		super(i, descricao, coordenada);
	}

	@Override
	public void acao(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "SONEGOU IMPOSTO\nVá para Prisão");
		ControlePrisao.getInstance().adicionarPreso(jogador);
		ControleJogador.getInstace().tornarPreso(jogador);
		ControleJogo.getInstance().moverParaPrisao(jogador);
	}

}
