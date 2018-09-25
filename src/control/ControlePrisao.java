package control;

import model.casa.CasaPrisao;
import model.interfaces.IJogador;
import model.interfaces.IPrisao;

public class ControlePrisao implements IPrisao{
	
	private static ControlePrisao controlePrisao;
	
	private ControlePrisao() {
	}
	
	public static ControlePrisao getInstance(){
		if(controlePrisao == null)
			controlePrisao = new ControlePrisao();
		return controlePrisao;
	}

	@Override
	public void adicionarPreso(IJogador jogador) {
		CasaPrisao.getInstance().getPresos().add(jogador);
	}
	@Override
	public void removerPreso(IJogador jogador) {
		CasaPrisao.getInstance().getPresos().remove(jogador);
	}


	@Override
	public boolean verificaSeTaPreso(IJogador jogador) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRegistro(IJogador jogador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zerarRegistro(IJogador jogador) {
		// TODO Auto-generated method stub
	}

}
