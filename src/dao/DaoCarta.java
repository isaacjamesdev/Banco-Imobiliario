package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.carta.CartaPasseLivre;
import model.carta.CartaPrisao;
import model.carta.CartaReves;
import model.carta.CartaSorte;
import model.interfaces.IEfeito;

public class DaoCarta implements IteratorCartas {
	private List<IEfeito> cartas;

	private static DaoCarta daoCartas;

	private DaoCarta() {
		cartas = new ArrayList<>();
		// cartas de sorte
		cartas.add(new CartaSorte(25));
		cartas.add(new CartaSorte(150));
		cartas.add(new CartaSorte(100));
		cartas.add(new CartaSorte(80));
		cartas.add(new CartaSorte(45));
		cartas.add(new CartaSorte(200));
		cartas.add(new CartaSorte(50));
		cartas.add(new CartaSorte(100));
		cartas.add(new CartaSorte(20));
		cartas.add(new CartaSorte(100));
		cartas.add(new CartaSorte(200));
		cartas.add(new CartaSorte(50));
		cartas.add(new CartaSorte(100));
		cartas.add(new CartaSorte(50));
		// cartas de azar
		cartas.add(new CartaReves(40));
		cartas.add(new CartaReves(50));
		cartas.add(new CartaReves(25));
		cartas.add(new CartaReves(50));
		cartas.add(new CartaReves(100));
		cartas.add(new CartaReves(100));
		cartas.add(new CartaReves(25));
		cartas.add(new CartaReves(30));
		cartas.add(new CartaReves(45));
		cartas.add(new CartaReves(50));
		cartas.add(new CartaReves(45));
		cartas.add(new CartaReves(15));
		cartas.add(new CartaReves(30));
		cartas.add(new CartaReves(30));
		// va para prisao
		cartas.add(new CartaPrisao());
		// passe livre da prisao

		cartas.add(new CartaPasseLivre());

	}

	public static DaoCarta getInstance() {
		if (daoCartas == null)
			daoCartas = new DaoCarta();
		return daoCartas;
	}

	public List<IEfeito> getCartas() {
		return cartas;
	}

	@Override
	public IEfeito proximaCarta() {
		return cartas.get(new Random().nextInt(cartas.size()));

	}

}
