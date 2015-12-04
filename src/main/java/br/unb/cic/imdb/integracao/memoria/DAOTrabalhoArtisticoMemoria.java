package br.unb.cic.imdb.integracao.memoria;

import java.util.List;

import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public class DAOTrabalhoArtisticoMemoria implements DAOTrabalhoArtistico {

	public List<TrabalhoArtistico> trabalhosArtisticos;
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

}
