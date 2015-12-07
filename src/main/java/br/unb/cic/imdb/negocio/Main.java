package br.unb.cic.imdb.negocio;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

import br.unb.cic.imdb.InterfaceGrafica.*;
import br.unb.cic.imdb.util.ContextoID;

public class Main {
	public static MainFrame Frame;
	public static IMDBFacade facade;
	public static Usuario user = new Usuario();
	
	public static void main(String args[]) {
		facade = ContextoID.instance().facade();
		//RETIRAR COMENTARIOS PARA POPULAR BANCO DE DADOS OU USAR VERSAO EM MEMORIA
//		Populador pop = new Populador();
//		pop.popular(facade);
		
		Frame = new MainFrame(new LoginPanel()); 
	}

}
