package control;

import javax.swing.JOptionPane;

import model.Jogador;
import model.carta.CartaPasseLivre;
import model.carta.CartaPrisao;
import model.carta.CartaReves;
import model.carta.CartaSorte;
import model.casa.CasaAzar;
import model.casa.CasaLucro;
import model.casa.CasaParadaLivre;
import model.casa.CasaPrisao;
import model.casa.CasaTerreno;
import model.casa.Companhia;
import model.casa.Propriedade;
import view.Som;

public class ControleCasas {
	private static ControleCasas controleCasas;

	public ControleCasas() {
		// TODO Auto-generated constructor stub
	}

	public static ControleCasas getInstance() {
		if (controleCasas == null)
			controleCasas = new ControleCasas();
		return controleCasas;
	}

	public void acao(CasaTerreno terreno, Jogador jogador) {
		if (terreno.getDono() == null) {
			int resposta = JOptionPane.showConfirmDialog(null, "A VENDA\n"
					+ terreno.getDescricao() + "\nDESEJA COMPRAR ?");
			if (resposta == 0) {
				if (jogador.getDinheiro() >= terreno.getValor()) {
					jogador.comprarPropriedade(terreno);
					terreno.setDono(jogador);
					JOptionPane.showMessageDialog(null, "COMPRADA");
					Som.playCash();
				} else
					JOptionPane.showMessageDialog(null,
							"Voce nao tem dinheiro !!");
			}
		}

		else if (terreno.getDono() == jogador)
			JOptionPane.showMessageDialog(null, "A casa ja é sua");

		else if (terreno.getDono() != jogador) {
			if (jogador.getDinheiro() < terreno.getPedagio())
				JOptionPane.showMessageDialog(null, "GAME OVER PARA VOCE!! "
						+ jogador.getNome() + ", voce nao tem dinheiro.");
			else {
				JOptionPane
						.showMessageDialog(null,
								"PEDAGIO:\nPague " + terreno.getPedagio()
										+ " para o " + jogador.getNome());
				Som.playCash();
				jogador.pagarTaxa(terreno.getPedagio());
				terreno.getDono().receberTaxa(terreno.getPedagio());
			}
		}
	}

	public boolean temDono(Propriedade propriedade) {
		return propriedade.temDono();
	}

	public void acao(CartaSorte cartaSorte, Jogador jogador) {
		JOptionPane.showMessageDialog(null,
				"Deu Sorte. Receba " + cartaSorte.getValor());
		jogador.receberTaxa(cartaSorte.getValor());

	}

	public void acao(CartaPasseLivre cartaPasseLivre, Jogador jogador) {
		JOptionPane
				.showMessageDialog(null,
						"Agora voce tem um passei livre da Prisao. \nUse quando necessario");
		jogador.setPasseLivre(true);

	}

	public void acao(CartaPrisao cartaPrisao, Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Deu Azar. Vai para prisao!");
		ControlePrisao.getInstance().adicionarPreso(jogador);
		ControleJogador.getInstace().tornarPreso(jogador);
		ControleJogo.getInstance().moverParaPrisao(jogador);
	}

	public void acao(CartaReves cartaReves, Jogador jogador) {
		JOptionPane.showMessageDialog(null,
				"Deu Azar. Pague " + cartaReves.getValor());
		jogador.pagarTaxa(cartaReves.getValor());

	}

	public void acao(CasaAzar casaAzar, Jogador jogador) {
		ControleJogador.getInstace().pagarTaxa(jogador, casaAzar.getValor());

	}

	public void acao(CasaLucro casaLucro, Jogador jogador) {
		ControleJogador.getInstace().receberTaxa(jogador, casaLucro.getValor());

	}

	public void acao(CasaParadaLivre casaParadaLivre, Jogador jogador) {
		ControleJogo.getInstance().Mensagem("Parada Livre, Descanse um pouco");

	}

	public void acao(CasaPrisao casaPrisao, Jogador jogador) {
		ControleJogo.getInstance().Mensagem("Você está só de visita. ");

	}

	public void acao(Companhia companhia, Jogador jogador) {
		if (companhia.getDono() == null) {
			int resposta = JOptionPane.showConfirmDialog(null,
					"A VENDA\n" + companhia.getDescricao() + "\n valor: "
							+ companhia.getValor());
			if (resposta == 0) {
				if (jogador.getDinheiro() >= companhia.getValor()) {
					jogador.comprarPropriedade(companhia);
					companhia.setDono(jogador);
					Som.playCash();
					JOptionPane.showMessageDialog(null, "COMPRADA!");
				} else
					JOptionPane.showMessageDialog(null,
							"OPS! Você não tem dinheiro !!");
			}
		}

		else if (companhia.getDono() == jogador)
			JOptionPane.showMessageDialog(null, "A casa ja é sua");

		else if (companhia.getDono() != jogador) {
			if (jogador.getDinheiro() < companhia.getPedagio(ControleDado
					.getInstance().getValorDados()))
				JOptionPane.showMessageDialog(null, "GAME OVER PARA VOCE!! "
						+ jogador.getNome() + ", voce nao tem dinheiro.");
			else {
				JOptionPane.showMessageDialog(null, "PEDAGIO: pague "
						+ companhia.getPedagio() + " para o "
						+ companhia.getDono().getNome());
				jogador.pagarTaxa(companhia.getPedagio(ControleDado
						.getInstance().getValorDados()));
				companhia.getDono().receberTaxa(
						companhia.getPedagio(ControleDado.getInstance()
								.getValorDados()));
				Som.playCash();
			}
		}

	}
}