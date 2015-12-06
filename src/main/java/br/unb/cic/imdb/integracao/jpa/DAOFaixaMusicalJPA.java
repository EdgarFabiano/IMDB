package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOFaixaMusical;
import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.FaixaMusical;

public class DAOFaixaMusicalJPA implements DAOFaixaMusical {

	private EntityManager em;
	@Override
	public void salvar(FaixaMusical faixaMusical) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(faixaMusical);
		em.getTransaction().commit();
	}

	@Override
	public List<FaixaMusical> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM FaixaMusical").getResultList();
	}

	@Override
	public List<FaixaMusical> recuperaPorAlbum(AlbumMusical albumMusical) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<FaixaMusical> faixas = em.createQuery("FROM FaixaMusical WHERE albumId = :albumIdParam").setParameter("albumIdParam", albumMusical.getId()).getResultList();
		return faixas.size() == 0 ? null : faixas;
	}

	@Override
	public FaixaMusical recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<FaixaMusical> faixas = em.createQuery("FROM FaixaMusical WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return faixas.size() == 1 ? faixas.get(0) : null;
	}

	@Override
	public void remover(FaixaMusical faixaMusical) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(faixaMusical);
		em.getTransaction().commit();
	}

}
