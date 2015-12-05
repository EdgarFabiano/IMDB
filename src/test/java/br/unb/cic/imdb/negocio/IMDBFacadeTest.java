package br.unb.cic.imdb.negocio;

import java.util.List;

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
	
	public void testeAdicionaAvaliacao() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
			
			Usuario foosuario = new Usuario("foo", "foo", "foo");
			foosuario.setId((long) 1);
			TrabalhoArtistico foobalho = new TrabalhoArtistico("foo", 32, null, null);
			foobalho.setId((long) 1);
			Avaliacao novaAvaliacao = new Avaliacao(10, "moh bom", foosuario, foobalho);
			
			int quantidadeAvaliacoes = facade.recuperarAvaliacoes().size();
			
			facade.adicionaAvaliacao(novaAvaliacao);
			
			List<Avaliacao> resultadoConsulta1 = facade.recuperarAvaliacoesPorUsuario(foosuario);
			List<Avaliacao> resultadoConsulta2 = facade.recuperarAvaliacoesPorTrabalhoArtistico(foobalho);
						
			assertEquals(quantidadeAvaliacoes+1, facade.recuperarAvaliacoes().size());
			assertNotNull(resultadoConsulta1);
			assertNotNull(resultadoConsulta2);
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
	
	public void testeAdicionaTrabalhoArtistico() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
			
			TrabalhoArtistico novoTrabalhoArtistico = new TrabalhoArtistico("Senhor dos Aneis", 2001, null, null);
			
			int quantidadeTrabalhosArtisticos = facade.recuperarTrabalhosArtisticos().size();
			
			facade.adicionaTrabalhoArtistico(novoTrabalhoArtistico);
			
			TrabalhoArtistico resultadoConsulta = facade.recuperarTrabalhoArtisticoPorTitulo("Senhor dos Aneis");
			
			assertEquals(quantidadeTrabalhosArtisticos+1, facade.recuperarTrabalhosArtisticos().size());
			assertNotNull(resultadoConsulta);
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
	
	public void testeAdicionaUsuario() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
			
			Usuario novoUsuario = new Usuario("pedrinho", "senha", "Jerivaldo");
			
			int quantidadeUsuarios = facade.recuperarUsuarios().size();
			
			facade.adicionaUsuario(novoUsuario);
			
			Usuario resultadoConsulta = facade.recuperarUsuarioPorLogin("pedrinho");
			
			assertEquals(quantidadeUsuarios+1, facade.recuperarUsuarios().size());
			assertNotNull(resultadoConsulta);
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
}
