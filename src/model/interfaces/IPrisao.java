package model.interfaces;


public interface IPrisao{
	
	public boolean verificaSeTaPreso(IJogador jogador);
	public void adicionarPreso(IJogador jogador);
	public void removerPreso(IJogador jogador);
	public void setRegistro(IJogador jogador);
	public void zerarRegistro(IJogador jogador);

}
