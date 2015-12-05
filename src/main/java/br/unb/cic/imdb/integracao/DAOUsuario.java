package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Usuario;

public interface DAOUsuario {

	public void salvar(Usuario usuario);
	public List<Usuario> recuperaTodos();
	public Usuario recuperaPorLogin(String login);
	public void remover(Usuario usuario);
}
