package br.unb.cic.imdb.negocio;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

import br.unb.cic.imdb.InterfaceGrafica.*;
import br.unb.cic.imdb.util.ContextoID;

@SuppressWarnings({ "unused" })
public class Main {
	public static MainFrame Frame;
	public static IMDBFacade facade;
	public static Usuario user = new Usuario();
	
	public static void main(String args[]) {
		facade = ContextoID.instance().facade();
		Populador pop = new Populador();

		try {
			pop.popular(facade);
		}
		catch (IllegalArgumentException e) {
			System.out.println("BD já populado");
		}
		
		Frame = new MainFrame(new LoginPanel()); 
	}

}
