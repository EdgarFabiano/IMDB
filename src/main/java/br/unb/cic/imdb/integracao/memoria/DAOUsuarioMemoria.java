package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOUsuario;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOUsuarioMemoria implements DAOUsuario {

	public List<Usuario> usuarios;
	
	public DAOUsuarioMemoria() {
		usuarios = new ArrayList<>();
	}
	
	@Override
	public void salvar(Usuario usuario) {
		usuarios.add(usuario);
	}

	@Override
	public List<Usuario> recuperaTodos() {
		return usuarios;
	}

	@Override
	public Usuario recuperaPorLogin(String login) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)) {
				return usuario;
			}
		}
		return null;
	}

}
