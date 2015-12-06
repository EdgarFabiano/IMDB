package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Genero;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public class DAOTrabalhoArtisticoMemoria implements DAOTrabalhoArtistico {

	public List<TrabalhoArtistico> trabalhosArtisticos;
	
	public DAOTrabalhoArtisticoMemoria() {
		trabalhosArtisticos = new ArrayList<>();
	}
	
	@Override
	public void salvar(TrabalhoArtistico trabalhoArtistico) {
		trabalhosArtisticos.add(trabalhoArtistico);
	}

	@Override
	public List<TrabalhoArtistico> recuperaTodos() {
		return trabalhosArtisticos;
	}

	@Override
	public TrabalhoArtistico recuperaPorTitulo(String titulo) {
		for (TrabalhoArtistico trabalhoArtistico : trabalhosArtisticos) {
			if (trabalhoArtistico.getTitulo().equals(titulo)) {
				return trabalhoArtistico;
			}
		}
		return null;
	}

	@Override
	public void remover(TrabalhoArtistico trabalhoArtistico) {
		trabalhosArtisticos.remove(trabalhoArtistico);
	}

	@Override
	public List<TrabalhoArtistico> recuperaPorGenero(Genero genero) {
		List<TrabalhoArtistico> res = new ArrayList<>();
		for (TrabalhoArtistico trabalhoArtistico : trabalhosArtisticos) {
			if (trabalhoArtistico.getGenero().equals(genero)) {
				res.add(trabalhoArtistico);
			}
		}
		return res.isEmpty() ? null : res;
	}

	@Override
	public List<TrabalhoArtistico> recuperaPorAutor(Autor autor) {
		List<TrabalhoArtistico> res = new ArrayList<>();
		for (TrabalhoArtistico trabalhoArtistico : trabalhosArtisticos) {
			if (trabalhoArtistico.getAutor().equals(autor)) {
				res.add(trabalhoArtistico);
			}
		}
		return res.isEmpty() ? null : res;
	}

}
