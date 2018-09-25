package control;

import java.util.ArrayList;
import java.util.List;

import model.dado.Dado;

public class ControleDado {
	
	private List<Dado> dados;
	
	private static ControleDado controleDado;
	
	private ControleDado() {
		// TODO Auto-generated constructor stub
	}
	
	public static ControleDado getInstance(){
		if(controleDado == null)
			controleDado = new ControleDado();
		return controleDado;
	}
	
	public int lancarDados(){
		dados = new ArrayList<>(2);
		dados.add(new Dado(100,100));
		dados.add(new Dado(200,200));
		return dados.get(0).getFace() + dados.get(1).getFace();
	}
	
	public List<Dado> getDados() {
		return dados;
	}

	public boolean dadosIguais(){
		if(dados.get(0).getFace() == dados.get(1).getFace())
			return true;
		return false;
	}

	public int getValorDados() {
		return dados.get(0).getFace()+dados.get(1).getFace();
	}

}
