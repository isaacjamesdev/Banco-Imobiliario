package view;
import jplay.Sprite;
import jplay.URL;

public class Pino extends Sprite{

	public Pino(String imagem){
		super(URL.sprite(imagem));
	}
}
