package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.negocio.Genero;

/**
 * Implementacao da interface DAOGenero usando 
 * a tecnologia JPA, tendo como uma das implementacoes 
 * o Hibernate. 
 * 
 * @author rbonifacio
 */
public class DAOGeneroJPA implements DAOGenero {
	
	@Override
	public void salvar(Genero genero) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.persist(genero);
		JPAUtil.em.getTransaction().commit();
	}

	@Override
	public List<Genero> recuperaTodos() {
		List<Genero> generos = JPAUtil.em.createQuery("FROM Genero").getResultList();
		return generos;
	}

	@Override
	public Genero recuperaPorTitulo(String titulo) {
		List<Genero> generos = JPAUtil.em.createQuery("FROM Genero WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return generos.size() == 1 ? generos.get(0): null;
	}

	@Override
	public void remover(Genero genero) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.remove(genero);
		JPAUtil.em.getTransaction().commit();
	}
	
}
