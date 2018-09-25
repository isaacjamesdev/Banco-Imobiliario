package model.dado;

import jplay.Animation;
import jplay.URL;

public class Dado {
	
	private static final int max = 6;
	private Animation imagemDado;
	private int face;
//	private static Dado dado;
	
	public Dado(int x, int y) {
		imagemDado = new Animation(URL.sprite("Dice1.png"), 6);
		imagemDado.x = x;
		imagemDado.y = y;
		lancar();
	}
	
//	public Dado getInstance(int x, int y){
//		if(dado == null)
//			dado = new Dado(x, y);
//		return dado;
//	}
	
	private void lancar(){
		int valor = (int) (Math.random() * max);
		imagemDado.setCurrFrame(valor);
		face = valor + 1;
	}
	
	public Animation getImagemDado(){
		return imagemDado;
	}
	
	public int getFace(){
		return face;
	}
}
