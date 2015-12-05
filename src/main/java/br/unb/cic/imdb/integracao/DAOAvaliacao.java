package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Avaliacao;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.negocio.Usuario;

public interface DAOAvaliacao {

	public void salvar(Avaliacao avaliacao);
	public List<Avaliacao> recuperaTodos();
	public List<Avaliacao> recuperaPorUsuario(Usuario usuario);
	public List<Avaliacao> recuperaPorTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico);
	public void remover(Avaliacao avaliacao);
}
