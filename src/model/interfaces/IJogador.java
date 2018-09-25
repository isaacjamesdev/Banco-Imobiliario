package model.interfaces;

import model.casa.Propriedade;

public interface IJogador {
	public void comprarPropriedade(Propriedade propriedade);
	public void pagarTaxa(int valor);	
	public void receberTaxa(int valaor);
	public void setPreso(boolean preso);

}
