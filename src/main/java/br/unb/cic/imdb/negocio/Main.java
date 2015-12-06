package br.unb.cic.imdb.negocio;

import br.unb.cic.imdb.InterfaceGrafica.*;
import br.unb.cic.imdb.util.ContextoID;

public class Main {
	public static MainFrame Frame;
	public static IMDBFacade facade;
	
	public static void main(String args[]) {
		facade = ContextoID.instance().facade();
		Frame = new MainFrame(new LoginPanel()); 
	}

}
