package br.unb.cic.imdb.integracao.memoria;

import java.util.List;

import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.negocio.Avaliacao;

public class DAOAvaliacaoMemoria implements DAOAvaliacao {

	public List<Avaliacao> avaliacoes;
	
	@Override
	public void salvar(Avaliacao avaliacao) {
		avaliacoes.add(avaliacao);

	}

	@Override
	public List<Avaliacao> recuperaTodos() {
		return avaliacoes;
	}

}
