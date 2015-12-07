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
import br.unb.cic.imdb.integracao.jpa.JPAUtil;

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
			JPAUtil.comecarOperacoes();
			daoGenero.salvar(genero);
			JPAUtil.finalizarOperacoes();
		}
		else { 
			throw new IllegalArgumentException();
		}
	}
		
	public List<Genero> recuperarGeneros() {
		JPAUtil.comecarOperacoes();
		List<Genero> generos = daoGenero.recuperaTodos();
		JPAUtil.finalizarOperacoes();
		return generos;
	}

	public Genero recuperarGeneroPorTitulo(String titulo) {
		JPAUtil.comecarOperacoes();
		Genero genero = daoGenero.recuperaPorTitulo(titulo);
		JPAUtil.finalizarOperacoes();
		return genero;
	}
	
	public void removerGenero(Genero genero) {
		if(recuperarGeneroPorTitulo(genero.getTitulo()) != null) {
			JPAUtil.comecarOperacoes();
			daoGenero.remover(genero);
			JPAUtil.finalizarOperacoes();
		}
	}
	
	//Operacoes de Autor
	public void adicionaAutor(Autor autor) {
		if(recuperarAutorPorNome(autor.getNome()) == null) {
			JPAUtil.comecarOperacoes();
			daoAutor.salvar(autor);
			JPAUtil.finalizarOperacoes();
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public List<Autor> recuperarAutores() {
		JPAUtil.comecarOperacoes();
		List<Autor> autores = daoAutor.recuperaTodos();
		JPAUtil.finalizarOperacoes();
		return autores;
	}
	
	public Autor recuperarAutorPorNome(String nome) {
		JPAUtil.comecarOperacoes();
		Autor autor = daoAutor.recuperaPorNome(nome);
		JPAUtil.finalizarOperacoes();
		return autor;
	}
	
	public void removerAutor(Autor autor) {
		if(recuperarAutorPorNome(autor.getNome()) != null) {
			JPAUtil.comecarOperacoes();
			daoAutor.remover(autor);
			JPAUtil.finalizarOperacoes();
		}
	}

	//Operacoes de Avaliacao
	public void adicionaAvaliacao(Avaliacao avaliacao){
		//O mesmo usuario pode avaliar o mesmo trabalho varias vezes(?)
		JPAUtil.comecarOperacoes();
		daoAvaliacao.salvar(avaliacao);
		JPAUtil.finalizarOperacoes();
	}
	
	public List<Avaliacao> recuperarAvaliacoes() {
		JPAUtil.comecarOperacoes();
		List<Avaliacao> avaliacoes = daoAvaliacao.recuperaTodos();
		JPAUtil.finalizarOperacoes();
		return avaliacoes;
	}
	
	public List<Avaliacao> recuperarAvaliacoesPorUsuario(Usuario usuario) {
		JPAUtil.comecarOperacoes();
		List<Avaliacao> avaliacoes = daoAvaliacao.recuperaPorUsuario(usuario);
		JPAUtil.finalizarOperacoes();
		return avaliacoes;
	}
	
	public List<Avaliacao> recuperarAvaliacoesPorTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
		JPAUtil.comecarOperacoes();
		List<Avaliacao> avaliacoes = daoAvaliacao.recuperaPorTrabalhoArtistico(trabalhoArtistico);
		JPAUtil.finalizarOperacoes();
		return avaliacoes;
	}
	
	public void removerAvaliacao(Avaliacao avaliacao) {
		if (recuperarAvaliacoesPorTrabalhoArtistico(avaliacao.getAvaliado()) != null ||
				recuperarAvaliacoesPorUsuario(avaliacao.getAvaliador()) != null) {
			JPAUtil.comecarOperacoes();
			daoAvaliacao.remover(avaliacao);
			JPAUtil.finalizarOperacoes();
		}
	}
	
	//Operacoes de TrabalhoArtistico
	//Podem existir trabalhos com o mesmo nome, mas de autores diferentes?
	public void adicionaTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
		if (recuperarTrabalhoArtisticoPorTitulo(trabalhoArtistico.getTitulo()) == null) {
			JPAUtil.comecarOperacoes();
			daoTrabalhoArtistico.salvar(trabalhoArtistico);
			JPAUtil.finalizarOperacoes();
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public List<TrabalhoArtistico> recuperarTrabalhosArtisticos() {
		JPAUtil.comecarOperacoes();
		List<TrabalhoArtistico> trabalhos = daoTrabalhoArtistico.recuperaTodos();
		JPAUtil.finalizarOperacoes();
		return trabalhos;
	}
	
	public TrabalhoArtistico recuperarTrabalhoArtisticoPorTitulo(String titulo) {
		JPAUtil.comecarOperacoes();
		TrabalhoArtistico trabalho = daoTrabalhoArtistico.recuperaPorTitulo(titulo);
		JPAUtil.finalizarOperacoes();
		return trabalho;
	}
	
	public List<TrabalhoArtistico> recuperarTrabalhoArtisticoPorGenero(Genero genero) {
		JPAUtil.comecarOperacoes();
		List<TrabalhoArtistico> trabalhos = daoTrabalhoArtistico.recuperaPorGenero(genero);
		JPAUtil.finalizarOperacoes();
		return trabalhos;
	}
	
	public List<TrabalhoArtistico> recuperarTrabalhoArtisticoPorAutor(Autor autor) {
		JPAUtil.comecarOperacoes();
		List<TrabalhoArtistico> trabalhos = daoTrabalhoArtistico.recuperaPorAutor(autor);
		JPAUtil.finalizarOperacoes();
		return trabalhos;
	}
	
	public void removerTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
		if(recuperarTrabalhoArtisticoPorTitulo(trabalhoArtistico.getTitulo()) != null) {
			JPAUtil.comecarOperacoes();
			daoTrabalhoArtistico.remover(trabalhoArtistico);
			JPAUtil.finalizarOperacoes();
		}
	}
	
	//Operacoes de Usuario
	public void adicionaUsuario(Usuario usuario) {
		if (!usuario.getLogin().equals("") && !usuario.getNome().equals("") && !usuario.getSenha().equals("")) {
			if (recuperarUsuarioPorLogin(usuario.getLogin()) == null){
				JPAUtil.comecarOperacoes();
				daoUsuario.salvar(usuario);
				JPAUtil.finalizarOperacoes();
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
		JPAUtil.comecarOperacoes();
		List<Usuario> usuarios = daoUsuario.recuperaTodos();
		JPAUtil.finalizarOperacoes();
		return usuarios;
	}
	
	public Usuario recuperarUsuarioPorLogin(String login) {
		JPAUtil.comecarOperacoes();
		Usuario usuario = daoUsuario.recuperaPorLogin(login);
		JPAUtil.finalizarOperacoes();
		return usuario;
	}
	
	public void removerUsuario(Usuario usuario) {
		Usuario foo = recuperarUsuarioPorLogin(usuario.getLogin());
		if (foo != null) {
			JPAUtil.comecarOperacoes();
			daoUsuario.remover(usuario);
			JPAUtil.finalizarOperacoes();
		}
	}
	
	public boolean autenticarUsuario (String login, String senha) {
		JPAUtil.comecarOperacoes();
		Usuario usuario = daoUsuario.recuperaPorLogin(login);
		JPAUtil.finalizarOperacoes();
		return senha.equals(usuario.getSenha());
		
	}
	
	//Operacoes de Faixa Musical
	public void adicionarFaixaMusical(FaixaMusical faixaMusical) {
		if (recuperarFaixaMusicalPorTitulo(faixaMusical.getTitulo()) == null) {
			JPAUtil.comecarOperacoes();
			daoFaixaMusical.salvar(faixaMusical);
			JPAUtil.finalizarOperacoes();
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public List<FaixaMusical> recuperarFaixasMusicais() {
		JPAUtil.comecarOperacoes();
		List<FaixaMusical> faixas = daoFaixaMusical.recuperaTodos();
		JPAUtil.finalizarOperacoes();
		return faixas;
	}
	
	public FaixaMusical recuperarFaixaMusicalPorTitulo(String titulo) {
		JPAUtil.comecarOperacoes();
		FaixaMusical faixa = daoFaixaMusical.recuperaPorTitulo(titulo);
		JPAUtil.finalizarOperacoes();
		return faixa;
	}
	
	public List<FaixaMusical> recuperarFaixaMusicalPorAutor(AlbumMusical albumMusical) {
		JPAUtil.comecarOperacoes();
		List<FaixaMusical> faixas = daoFaixaMusical.recuperaPorAlbum(albumMusical);
		JPAUtil.finalizarOperacoes();
		return faixas;
	}
	
	public void removerFaixaMusical(FaixaMusical faixaMusical) {
		JPAUtil.comecarOperacoes();
		daoFaixaMusical.remover(faixaMusical);
		JPAUtil.finalizarOperacoes();
	}
}
