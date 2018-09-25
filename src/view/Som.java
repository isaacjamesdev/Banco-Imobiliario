package view;

import jplay.Sound;
import jplay.URL;

public class Som {
	
	private static Sound cash;
	
	public static void playCash(){
		cash = new Sound(URL.audio("caixinha.wav"));
		Som.cash.play();
	}

}
