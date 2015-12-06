package br.unb.cic.imdb.negocio;

import java.security.InvalidParameterException;
import java.util.List;

import javax.activity.InvalidActivityException;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.integracao.DAOFaixaMusical;
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
	private DAOFaixaMusical daoFaixaMusical;

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

	public void setDaoFaixaMusical(DAOFaixaMusical daoFaixaMusical) {
		this.daoFaixaMusical = daoFaixaMusical;
	}

	//Operacoes de Genero
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
	
	public void removerGenero(Genero genero) {
		if(recuperarGeneroPorTitulo(genero.getTitulo()) != null) {
			daoGenero.remover(genero);
		}
	}
	
	//Operacoes de Autor
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
	
	public void removerAutor(Autor autor) {
		if(recuperarAutorPorNome(autor.getNome()) != null) {
			daoAutor.remover(autor);
		}
	}

	//Operacoes de Avaliacao
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
	
	public void removerAvaliacao(Avaliacao avaliacao) {
		if (recuperarAvaliacoesPorTrabalhoArtistico(avaliacao.getAvaliado()) != null ||
				recuperarAvaliacoesPorUsuario(avaliacao.getAvaliador()) != null) {
			daoAvaliacao.remover(avaliacao);
		}
	}
	
	//Operacoes de TrabalhoArtistico
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
	
	public List<TrabalhoArtistico> recuperarTrabalhoArtisticoPorGenero(Genero genero) {
		return daoTrabalhoArtistico.recuperaPorGenero(genero);
	}
	
	public List<TrabalhoArtistico> recuperarTrabalhoArtisticoPorAutor(Autor autor) {
		return daoTrabalhoArtistico.recuperaPorAutor(autor);
	}
	
	public void removerTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
		if(recuperarTrabalhoArtisticoPorTitulo(trabalhoArtistico.getTitulo()) != null) {
			daoTrabalhoArtistico.remover(trabalhoArtistico);
		}
	}
	
	//Operacoes de Usuario
	public void adicionaUsuario(Usuario usuario) {
		if (usuario.getLogin().equals("") || usuario.getNome().equals("") || usuario.getSenha().equals("")) {
			if (recuperarUsuarioPorLogin(usuario.getLogin()) == null){
				daoUsuario.salvar(usuario);
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new InvalidParameterException();
		}
	}
	
	public List<Usuario> recuperarUsuarios() {
		return daoUsuario.recuperaTodos();
	}
	
	public Usuario recuperarUsuarioPorLogin(String login) {
		return daoUsuario.recuperaPorLogin(login);
	}
	
	public void removerUsuario(Usuario usuario) {
		if (recuperarUsuarioPorLogin(usuario.getLogin()) != null) {
			daoUsuario.remover(usuario);
		}
	}
	
	public boolean autenticarUsuario (String login, String senha) {
		Usuario usuario = daoUsuario.recuperaPorLogin(login);
		return senha.equals(usuario.getSenha());
	}
	
	//Operacoes de Faixa Musical
	public void adicionarFaixaMusical(FaixaMusical faixaMusical) {
		if (recuperarFaixaMusicalPorTitulo(faixaMusical.getTitulo()) == null) {
			daoFaixaMusical.salvar(faixaMusical);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public List<FaixaMusical> recuperarFaixasMusicais() {
		return daoFaixaMusical.recuperaTodos();
	}
	
	public FaixaMusical recuperarFaixaMusicalPorTitulo(String titulo) {
		return daoFaixaMusical.recuperaPorTitulo(titulo);
	}
	
	public List<FaixaMusical> recuperarFaixaMusicalPorAutor(AlbumMusical albumMusical) {
		return daoFaixaMusical.recuperaPorAlbum(albumMusical);
	}
	
	public void removerFaixaMusical(FaixaMusical faixaMusical) {
		daoFaixaMusical.remover(faixaMusical);
	}
}
