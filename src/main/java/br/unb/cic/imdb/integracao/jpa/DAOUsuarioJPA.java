package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOUsuario;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOUsuarioJPA implements DAOUsuario {

	private EntityManager em;
	@Override
	public void salvar(Usuario usuario) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

	@Override
	public List<Usuario> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Usuario> usuarios = em.createQuery("FROM Usuarios").getResultList();
		return usuarios;
	}

	@Override
	public Usuario recuperaPorLogin(String login) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Usuario> usuarios = em.createQuery("FROM Usuarios WHERE login = :loginParam").setParameter("loginParam", login).getResultList();
		return usuarios.size() == 1 ? usuarios.get(0) : null;
	}

	@Override
	public void remover(Usuario usuario) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}

}
