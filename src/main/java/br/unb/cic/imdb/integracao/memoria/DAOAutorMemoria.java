package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.negocio.Autor;

public class DAOAutorMemoria implements DAOAutor {
	private List<Autor> autores;
	
	public DAOAutorMemoria() {
		autores =  new ArrayList<>();
	}

	@Override
	public void salvar(Autor autor) {
		autores.add(autor);
		
	}

	@Override
	public List<Autor> recuperaTodos() {
		return autores;
	}

	@Override
	public Autor recuperaPorNome(String nome) {
		for (Autor autor : autores){
			if (autor.getNome().equals(nome)) {
				return autor;
			}
		}
		return null;
	}

	@Override
	public void remover(Autor autor) {
		autores.remove(autor);
	}

}
