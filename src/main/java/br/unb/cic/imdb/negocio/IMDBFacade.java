package br.unb.cic.imdb.negocio;

import java.util.List;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.integracao.DAOGenero;

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

	public IMDBFacade() {}
	
	//Usando o Spring Framework, o construtor declarado 
	//nas proximas linhas se torna desnecessario, uma vez 
	//que o proprio Spring injeta as implementacoes corretas das classes DAOs. 
	
//	public IMDBFacade() {
//			daoGenero = DAOFactory.instance(DataBase.SQLDB).createDAOGenero();
//	}
	
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
	
	public void setDaoGenero(DAOGenero daoGenero) {
		this.daoGenero = daoGenero;
	}
	
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
	
	public void setDaoAutor(DAOAutor daoAutor) {
		this.daoAutor = daoAutor;
	}
	
}
