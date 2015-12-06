package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Genero;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public interface DAOTrabalhoArtistico {

	public void salvar(TrabalhoArtistico trabalhoArtistico);
	public List<TrabalhoArtistico> recuperaTodos();
	public TrabalhoArtistico recuperaPorTitulo(String titulo);
	public List<TrabalhoArtistico> recuperaPorGenero(Genero genero);
	public List<TrabalhoArtistico> recuperaPorAutor(Autor autor);
	public void remover(TrabalhoArtistico trabalhoArtistico);
	
}
