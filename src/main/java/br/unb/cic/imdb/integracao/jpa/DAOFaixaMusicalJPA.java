package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOFaixaMusical;
import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.FaixaMusical;

@SuppressWarnings({ "unchecked", "unused" })
public class DAOFaixaMusicalJPA implements DAOFaixaMusical {

	@Override
	public void salvar(FaixaMusical faixaMusical) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.persist(faixaMusical);
		JPAUtil.em.getTransaction().commit();
	}

	@Override
	public List<FaixaMusical> recuperaTodos() {
		List<FaixaMusical> faixas = JPAUtil.em.createQuery("FROM FaixaMusical").getResultList();
		return faixas;
	}

	@Override
	public List<FaixaMusical> recuperaPorAlbum(AlbumMusical albumMusical) {
		List<FaixaMusical> faixas = JPAUtil.em.createQuery("FROM FaixaMusical WHERE id_trabalho_artistico = :albumIdParam").setParameter("albumIdParam", albumMusical.getId()).getResultList();
		return faixas.size() == 0 ? null : faixas;
	}

	@Override
	public FaixaMusical recuperaPorTitulo(String titulo) {
		List<FaixaMusical> faixas = JPAUtil.em.createQuery("FROM FaixaMusical WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return faixas.size() == 1 ? faixas.get(0) : null;
	}

	@Override
	public void remover(FaixaMusical faixaMusical) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.remove(faixaMusical);
		JPAUtil.em.getTransaction().commit();
	}

}
