package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.negocio.Avaliacao;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.negocio.Usuario;

@SuppressWarnings({ "unchecked", "unused" })
public class DAOAvaliacaoJPA implements DAOAvaliacao {

	@Override
	public void salvar(Avaliacao avaliacao) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.persist(avaliacao);
		JPAUtil.em.getTransaction().commit();
	}

	@Override
	public List<Avaliacao> recuperaTodos() {
		List<Avaliacao> avaliacoes = JPAUtil.em.createQuery("FROM Avaliacao").getResultList(); 
		return avaliacoes;
	}

	@Override
	public List<Avaliacao> recuperaPorUsuario(Usuario usuario) {
		List<Avaliacao> avaliacoes = JPAUtil.em.createQuery("FROM Avaliacao WHERE id_usuario = :usuarioIdParam").setParameter("usuarioIdParam", usuario.getId()).getResultList();
		return avaliacoes.size() == 0 ? null : avaliacoes;
	}

	@Override
	public List<Avaliacao> recuperaPorTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
		List<Avaliacao> avaliacoes = JPAUtil.em.createQuery("FROM Avaliacao WHERE id_trabalho_artistico = :trabalhoIdParam").setParameter("trabalhoIdParam", trabalhoArtistico.getId()).getResultList();
		return avaliacoes.size() == 0 ? null : avaliacoes;
	}

	@Override
	public void remover(Avaliacao avaliacao) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.remove(avaliacao);
		JPAUtil.em.getTransaction().commit();
	}

}
