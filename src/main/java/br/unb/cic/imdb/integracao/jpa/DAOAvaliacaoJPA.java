package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.negocio.Avaliacao;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOAvaliacaoJPA implements DAOAvaliacao {

	private EntityManager em;
	@Override
	public void salvar(Avaliacao avaliacao) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(avaliacao);
		em.getTransaction().commit();
	}

	@Override
	public List<Avaliacao> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Avaliacao").getResultList();
	}

	@Override
	public List<Avaliacao> recuperaPorUsuario(Usuario usuario) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Avaliacao> avaliacoes = em.createQuery("FROM Avaliacao WHERE id_usuario = :usuarioIdParam").setParameter("usuarioIdParam", usuario.getId()).getResultList();
		return avaliacoes.size() == 0 ? null : avaliacoes;
	}

	@Override
	public List<Avaliacao> recuperaPorTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Avaliacao> avaliacoes = em.createQuery("FROM Avaliacao WHERE id_trabalho_artistico = :trabalhoIdParam").setParameter("trabalhoIdParam", trabalhoArtistico.getId()).getResultList();
		return avaliacoes.size() == 0 ? null : avaliacoes;
	}

	@Override
	public void remover(Avaliacao avaliacao) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(avaliacao);
		em.getTransaction().commit();
	}

}
