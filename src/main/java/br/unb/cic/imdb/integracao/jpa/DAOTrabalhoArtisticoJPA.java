package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public class DAOTrabalhoArtisticoJPA implements DAOTrabalhoArtistico {

	private EntityManager em;
	@Override
	public void salvar(TrabalhoArtistico trabalhoArtistico) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(trabalhoArtistico);
		em.getTransaction().commit();
	}

	@Override
	public List<TrabalhoArtistico> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<TrabalhoArtistico> trabalhos = em.createQuery("FROM TrabalhosArtisticos").getResultList();
		return trabalhos;
	}

	@Override
	public TrabalhoArtistico recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<TrabalhoArtistico> trabalhos = em.createQuery("FROM TrabalhosArtisticos WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return trabalhos.size() == 1 ? trabalhos.get(0) : null;
	}

	@Override
	public void remover(TrabalhoArtistico trabalhoArtistico) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(trabalhoArtistico);
		em.getTransaction().commit();
	}

}
