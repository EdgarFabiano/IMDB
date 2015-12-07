package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOUsuario;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOUsuarioJPA implements DAOUsuario {

	@Override
	public void salvar(Usuario usuario) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.persist(usuario);
		JPAUtil.em.getTransaction().commit();
	}

	@Override
	public List<Usuario> recuperaTodos() {
		List<Usuario> usuarios = JPAUtil.em.createQuery("FROM Usuario").getResultList();
		return usuarios;
	}

	@Override
	public Usuario recuperaPorLogin(String login) {
		List<Usuario> usuarios = JPAUtil.em.createQuery("FROM Usuario WHERE login = :loginParam").setParameter("loginParam", login).getResultList();
		return usuarios.size() == 1 ? usuarios.get(0) : null;
	}

	@Override
	public void remover(Usuario usuario) {
		JPAUtil.em.getTransaction().begin();
		JPAUtil.em.remove(usuario);
		JPAUtil.em.getTransaction().commit();
	}

}
