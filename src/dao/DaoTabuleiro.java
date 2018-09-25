package dao;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.casa.CasaAzar;
import model.casa.CasaInicio;
import model.casa.CasaLucro;
import model.casa.CasaParadaLivre;
import model.casa.CasaPrisao;
import model.casa.CasaTabuleiro;
import model.casa.CasaTerreno;
import model.casa.CasaVaParaPrisao;
import model.casa.Companhia;
import model.casa.SorteOuReves;

public class DaoTabuleiro {
	
	public List<CasaTabuleiro> getCasas() {
		return casas;
	}

	public static DaoTabuleiro getDaoPropriedade() {
		return daoPropriedade;
	}

	private List<CasaTabuleiro> casas;
	private static DaoTabuleiro daoPropriedade;
	
	private DaoTabuleiro() {
		casas = new ArrayList<CasaTabuleiro>();
		
		casas.add(new CasaInicio(0, "Casa de Inicio.", 200, new Point(640,655)));
		casas.add(new CasaTerreno(1,"LEBLON", 100, 6, new Point(560, 630)));
		casas.add(new SorteOuReves(2,"Tente a sorte puxando uma carta",new Point(500, 630)));
		casas.add(new CasaTerreno(3,"AV. PRESIDENTE VARGAS",60,2, new Point(440, 630)));
		casas.add(new CasaTerreno(4, "AV. NOSSA S. DE COPACABANA",60,4, new Point(390, 630)));
		casas.add(new Companhia(5, "COMPANHIA FERROVIARIA",200,50, new Point(330, 630)));
		casas.add(new CasaTerreno(6, "AV. BRIGADEIRO FARIA LIMA",240,20, new Point(280, 630)));
		casas.add(new Companhia(7, "COMPANHIA DE VIACAO",200,50, new Point(220, 630)));
		casas.add(new CasaTerreno(8, "AV. REBOUCAS",200,18, new Point(160, 630)));
		casas.add(new CasaTerreno(9, "AV. 9 DE JULHO",220, 18, new Point(110, 630)));
		casas.add(CasaPrisao.getInstance(10, "Estar só visitando os presos", new Point(30,630)));
		casas.add(new CasaTerreno(11, "AV. EUROPA",200,16, new Point(30, 550)));
		casas.add(new SorteOuReves(12, "Tente a sorte puxando uma carta", new Point(30, 490)));
		casas.add(new CasaTerreno(13, "RUA AUGUSTA",180,14, new Point(30, 435)));
		casas.add(new CasaTerreno(14, "PACAEMBU",180,14, new Point(30, 380)));
		casas.add(new Companhia(15, "COMPANHIA DE TAXI",150, 40, new Point(30, 320)));
		casas.add(new SorteOuReves(16, "Tente a sorte puxando uma carta", new Point(30, 265)));
		casas.add(new CasaTerreno(17, "INTERLAGOS",350, 35, new Point(30, 210)));
		casas.add(new CasaLucro(18, "Restituição do imposto de renda. ganhe $200", 200, new Point(30, 150)));
		casas.add(new CasaTerreno(19, "MORUMBI",400,50, new Point(30, 95)));
		casas.add(new CasaParadaLivre(20, "Faça porra nenhuma", new Point(30,30)));
		casas.add(new CasaTerreno(21, "FLAMENGO",120,8, new Point(110, 30)));
		casas.add(new SorteOuReves(22, "Tente a sorte puxando uma carta", new Point(160, 30)));
		casas.add(new CasaTerreno(23, "BOTAFOGO",100,6, new Point(220, 30)));
		casas.add(new CasaAzar(24, "Pague o imposto de renda. $200", 200, new Point(280, 30)));
		casas.add(new Companhia(25, "COMPANHIA DE NAVEGACAO",150,40, new Point(330,30)));
		casas.add(new CasaTerreno(26, "AV. BRASIL",160,12, new Point(390,30)));
		casas.add(new SorteOuReves(27, "Tente a sorte puxando uma carta", new Point(440, 30)));
		casas.add(new CasaTerreno(28, "AV. PAULISTA",140,10, new Point(500,30)));
		casas.add(new CasaTerreno(29, "JARDIM EUROPA",140,10, new Point(560, 30)));
		casas.add(new CasaVaParaPrisao(30,"Vá para a prisão, Otario", new Point(640,30)));
		casas.add(new CasaTerreno(31, "COPACANA",260, 22, new Point(640, 95)));
		casas.add(new Companhia(32, "COMPANHIA DE AVIACAO",200, 50, new Point(640, 150)));
		casas.add(new CasaTerreno(33, "AV. VIEIRA SOUTO",320,28, new Point(640, 210)));
		casas.add(new CasaTerreno(34, "AV. ATLANTICA",300, 26, new Point(640, 265)));
		casas.add(new Companhia(35,"COMPANHIA DE TAXI AEREO",200, 50, new Point(640, 320)));
		casas.add(new CasaTerreno(36, "IPANEMA",300,26, new Point(640, 380)));
		casas.add(new SorteOuReves(37,"Tente a sorte puxando uma carta", new Point(640, 435)));
		casas.add(new CasaTerreno(38, "JARDIM PAULISTA",280,24, new Point(640, 490)));
		casas.add(new CasaTerreno(39,"BROOKLIN",260,22, new Point(640, 550)));
		
	}
	
	public static DaoTabuleiro getInstance(){
		if(daoPropriedade == null)
			daoPropriedade = new DaoTabuleiro();
		return daoPropriedade; 
	}

}
