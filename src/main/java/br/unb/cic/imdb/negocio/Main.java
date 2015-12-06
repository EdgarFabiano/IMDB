package br.unb.cic.imdb.negocio;

import br.unb.cic.imdb.InterfaceGrafica.*;

public class Main {
	public static MainFrame Frame;
	public static IMDBFacade facade;
	
	public static void main(String args[]) {
		Frame = new MainFrame(new LoginPanel()); 
	}

}
