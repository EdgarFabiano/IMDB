package br.unb.cic.imdb.negocio;

import br.unb.cic.imdb.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest extends TestCase {

	public void testeAdicionaGenero() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
		
			Genero novoGenero = new Genero("Rock", "Ok... bem melhor!"); 
		
			int quantidadeGeneros = facade.recuperarGeneros().size();
		
			facade.adicionaGenero(novoGenero);
		
			Genero resultadoConsulta = facade.recuperarGeneroPorTitulo("Rock");
		
			assertEquals(quantidadeGeneros+1, facade.recuperarGeneros().size());
			assertNotNull(resultadoConsulta);		
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
	
	public void testeAdicionaAutor() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
			
			Autor novoAutor = new Autor("Wesley Safadao", "O SafaRei");
			
			int quantidadeAutores = facade.recuperarAutores().size();
			
			facade.adicionaAutor(novoAutor);
			
			Autor resultadoConsulta = facade.recuperarAutorPorNome("Wesley Safadao");
			
			assertEquals(quantidadeAutores+1, facade.recuperarAutores().size());
			assertNotNull(resultadoConsulta);
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
}
