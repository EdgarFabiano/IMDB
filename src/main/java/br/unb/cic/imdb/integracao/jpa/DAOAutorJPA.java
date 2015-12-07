package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.negocio.Autor;

public class DAOAutorJPA implements DAOAutor {
	

	@Override
	public void salvar(Autor autor) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.persist(autor);
		JPAUtil.em.getTransaction().commit();
	}

	@Override
	public List<Autor> recuperaTodos() {
		List<Autor> autores = JPAUtil.em.createQuery("FROM Autor").getResultList();
		return autores;
	}

	@Override
	public Autor recuperaPorNome(String nome) {
		List<Autor> autores = JPAUtil.em.createQuery("FROM Autor WHERE nome = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return autores.size() == 1 ? autores.get(0) : null;
	}

	@Override
	public void remover(Autor autor) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.remove(autor);
		JPAUtil.em.getTransaction().commit();
	}

}
