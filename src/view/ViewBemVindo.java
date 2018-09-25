package view;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class ViewBemVindo {
//	---------
	private static  Window janela;
	private static GameImage plano;
//	---------
	private static Keyboard teclado;
	private static ViewBemVindo view;
//	---------
	private ViewBemVindo() {
		// TODO Auto-generated constructor stub
	}
	
	public static ViewBemVindo getInstance(){
		if(view == null)
			view = new ViewBemVindo();
		return view;
	}
	
	
	public void telaBemVindo(){
		janela = new Window(700, 393);
		plano = new GameImage(URL.sprite("welcome.jpeg"));
		teclado = janela.getKeyboard();
		while(true){
			plano.draw();
			janela.update();
			if(teclado.keyDown(Keyboard.ENTER_KEY))
				new ViewJogo(janela);
		}
	}

}
