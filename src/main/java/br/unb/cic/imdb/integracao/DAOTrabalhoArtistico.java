package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public interface DAOTrabalhoArtistico {

	public void salvar (TrabalhoArtistico trabalhoArtistico);
	public List<TrabalhoArtistico> recuperaTodos();
	public TrabalhoArtistico recuperaPorTitulo(String titulo);
	
}
