package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Genero;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

@SuppressWarnings({ "unchecked", "unused" })
public class DAOTrabalhoArtisticoJPA implements DAOTrabalhoArtistico {

	@Override
	public void salvar(TrabalhoArtistico trabalhoArtistico) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.persist(trabalhoArtistico);
		JPAUtil.em.getTransaction().commit();
	}

	@Override
	public List<TrabalhoArtistico> recuperaTodos() {
		List<TrabalhoArtistico> trabalhos = JPAUtil.em.createQuery("FROM TrabalhoArtistico").getResultList();
		return trabalhos;
	}

	@Override
	public TrabalhoArtistico recuperaPorTitulo(String titulo) {
		List<TrabalhoArtistico> trabalhos = JPAUtil.em.createQuery("FROM TrabalhoArtistico WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return trabalhos.size() == 1 ? trabalhos.get(0) : null;
	}

	@Override
	public void remover(TrabalhoArtistico trabalhoArtistico) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.remove(trabalhoArtistico);
		JPAUtil.em.getTransaction().commit();
	}

	@Override
	public List<TrabalhoArtistico> recuperaPorGenero(Genero genero) {
		List<TrabalhoArtistico> trabalhos = JPAUtil.em.createQuery("FROM TrabalhoArtistico WHERE id_genero = :generoIdParam").setParameter("generoIdParam", genero.getId()).getResultList();
		return trabalhos.size() == 0 ? null : trabalhos;
	}

	@Override
	public List<TrabalhoArtistico> recuperaPorAutor(Autor autor) {
		List<TrabalhoArtistico> trabalhos = JPAUtil.em.createQuery("FROM TrabalhoArtistico WHERE id_autor = :autorIdParam").setParameter("autorIdParam", autor.getId()).getResultList();
		return trabalhos.size() == 0 ? null : trabalhos;
	}

}
