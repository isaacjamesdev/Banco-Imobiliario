package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.casa.CasaTabuleiro;
import model.casa.Propriedade;
import model.interfaces.IJogador;
import view.Pino;
import dao.DaoTabuleiro;

public class Jogador implements IJogador {

	public Pino getPino() {
		return pino;
	}

	private String nome;
	private int dinheiro;
	private boolean preso;
	private int registroPrisao;
	private int registroDados;
	private List<Propriedade> propriedades;
	private boolean passeLivre;
	private CasaTabuleiro casaAtual;
	private Pino pino;

	public Jogador(String nome, String img) {
		pino = new Pino(img);
		this.nome = nome;
		dinheiro = 2458;
		preso = false;
		registroPrisao = 0;
		propriedades = new ArrayList<>();
		passeLivre = false;

		casaAtual = DaoTabuleiro.getInstance().getCasas().get(0);
	}

	public int getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}

	public boolean isPreso() {
		return preso;
	}

	public void setPreso(boolean preso) {
		this.preso = preso;
	}

	public int getRegistroPrisao() {
		return registroPrisao;
	}

	public void setRegistroPrisao() {
		registroPrisao += 1;
	}
	
	public void zeraRegistroPrisao(){
		registroPrisao = 0;
	}

	public boolean isPasseLivre() {
		return passeLivre;
	}

	public void setPasseLivre(boolean passeLivre) {
		this.passeLivre = passeLivre;
	}

	public String getNome() {
		return nome;
	}

	public List<Propriedade> getPropriedades() {
		return propriedades;
	}

	@Override
	public void pagarTaxa(int valor) {
		dinheiro -= valor;
	}

	@Override
	public void receberTaxa(int valor) {
		dinheiro += valor;
	}
	// desnecessario
	@Override
	public void comprarPropriedade(Propriedade propriedade) {
		pagarTaxa(propriedade.getValor());
		propriedades.add(propriedade);
	}

	public int getRegistroDados() {
		return registroDados;
	}

	public void setRegistroDados() {
		registroDados += 1;
	}
	
	public void zeraRegistroDados(){
		registroDados = 0;
	}
	
	
	public CasaTabuleiro getCasaAtual() {
		return casaAtual;
	}
	
	public Point getCoordenada(){
		return casaAtual.getCoordenada();
	}

	public void setCasaAtual(CasaTabuleiro casaAtual) {
		this.casaAtual = casaAtual;
		pino.x = casaAtual.getCoordenada().getX();
		pino.y = casaAtual.getCoordenada().getY();
	}

}
