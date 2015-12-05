package br.unb.cic.imdb.negocio;

import java.util.List;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import br.unb.cic.imdb.integracao.DAOUsuario;

/**
 * Classe de fachada (Facade class) que vai servir de comunicacao 
 * entre a camada de apresentacao (ui) e a camada de negocio. Caso 
 * se torne excessivamente complexa, essa classe deve ser sub-dividida.
 *  
 * @author rbonifacio
 */
public class IMDBFacade {
	
	private DAOGenero daoGenero;
	private DAOAutor daoAutor;
	private DAOAvaliacao daoAvaliacao;
	private DAOTrabalhoArtistico daoTrabalhoArtistico;
	private DAOUsuario daoUsuario;

	public IMDBFacade() {}
	
	//Usando o Spring Framework, o construtor declarado 
	//nas proximas linhas se torna desnecessario, uma vez 
	//que o proprio Spring injeta as implementacoes corretas das classes DAOs. 
	
//	public IMDBFacade() {
//			daoGenero = DAOFactory.instance(DataBase.SQLDB).createDAOGenero();
//	}
	
	public void setDaoGenero(DAOGenero daoGenero) {
		this.daoGenero = daoGenero;
	}
	
	public void setDaoAutor(DAOAutor daoAutor) {
		this.daoAutor = daoAutor;
	}

	public void setDaoAvaliacao(DAOAvaliacao daoAvaliacao) {
		this.daoAvaliacao = daoAvaliacao;
	}

	public void setDaoTrabalhoArtistico(DAOTrabalhoArtistico daoTrabalhoArtistico) {
		this.daoTrabalhoArtistico = daoTrabalhoArtistico;
	}

	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	//Genero
	public void adicionaGenero(Genero genero) {
		if(recuperarGeneroPorTitulo(genero.getTitulo()) == null) {
			daoGenero.salvar(genero);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}
		
	public List<Genero> recuperarGeneros() {
		return daoGenero.recuperaTodos();
	}

	public Genero recuperarGeneroPorTitulo(String titulo) {
		return daoGenero.recuperaPorTitulo(titulo);
	}
	
	//Autor
	public void adicionaAutor(Autor autor) {
		if(recuperarAutorPorNome(autor.getNome()) == null) {
			daoAutor.salvar(autor);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public List<Autor> recuperarAutores() {
		return daoAutor.recuperaTodos();
	}
	
	public Autor recuperarAutorPorNome(String nome) {
		return daoAutor.recuperaPorNome(nome);
	}

	//Avaliacao
	public void adicionaAvaliacao(Avaliacao avaliacao){
		//O mesmo usuario pode avaliar o mesmo trabalho varias vezes(?)
		daoAvaliacao.salvar(avaliacao);
	}
	
	public List<Avaliacao> recuperarAvaliacoes() {
		return daoAvaliacao.recuperaTodos();
	}
	
	public List<Avaliacao> recuperarAvaliacoesPorUsuario(Usuario usuario) {
		return daoAvaliacao.recuperaPorUsuario(usuario);
	}
	
	public List<Avaliacao> recuperarAvaliacoesPorTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
		return daoAvaliacao.recuperaPorTrabalhoArtistico(trabalhoArtistico);
	}
	
	//TrabalhoArtistico
	//Podem existir trabalhos com o mesmo nome, mas de autores diferentes?
	public void adicionaTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
		if (recuperarTrabalhoArtisticoPorTitulo(trabalhoArtistico.getTitulo()) == null) {
			daoTrabalhoArtistico.salvar(trabalhoArtistico);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public List<TrabalhoArtistico> recuperarTrabalhosArtisticos() {
		return daoTrabalhoArtistico.recuperaTodos();
	}
	
	public TrabalhoArtistico recuperarTrabalhoArtisticoPorTitulo(String titulo) {
		return daoTrabalhoArtistico.recuperaPorTitulo(titulo);
	}
	
	//Usuario
	public void adicionaUsuario(Usuario usuario) {
		if (recuperarUsuarioPorLogin(usuario.getLogin()) == null){
			daoUsuario.salvar(usuario);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public List<Usuario> recuperarUsuarios() {
		return daoUsuario.recuperaTodos();
	}
	
	public Usuario recuperarUsuarioPorLogin(String login) {
		return daoUsuario.recuperaPorLogin(login);
	}
	
}
