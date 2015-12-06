package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.FaixaMusical;

public interface DAOFaixaMusical {

	public void salvar(FaixaMusical faixaMusical);
	public List<FaixaMusical> recuperaTodos();
	public List<FaixaMusical> recuperaPorAlbum(AlbumMusical albumMusical);
	public FaixaMusical recuperaPorTitulo(String titulo);
	public void remover(FaixaMusical faixaMusical);
}
