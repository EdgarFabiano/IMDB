package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.negocio.Avaliacao;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOAvaliacaoMemoria implements DAOAvaliacao {

	public List<Avaliacao> avaliacoes;
	
	public DAOAvaliacaoMemoria() {
		avaliacoes = new ArrayList<>();
	}
	
	@Override
	public void salvar(Avaliacao avaliacao) {
		avaliacoes.add(avaliacao);
	}

	@Override
	public List<Avaliacao> recuperaTodos() {
		return avaliacoes;
	}

	@Override
	public List<Avaliacao> recuperaPorUsuario(Usuario usuario) {
		List<Avaliacao> res = new ArrayList<>();
		for (Avaliacao avaliacao : avaliacoes) {
			if (avaliacao.getAvaliador().getId().equals(usuario.getId())) {
				res.add(avaliacao);
			}
		}
		return res.isEmpty() ? null : res;
	}

	@Override
	public List<Avaliacao> recuperaPorTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
		List<Avaliacao> res = new ArrayList<>();
		for (Avaliacao avaliacao : avaliacoes) {
			if (avaliacao.getAvaliado().getId().equals(trabalhoArtistico.getId())) {
				res.add(avaliacao);
			}
		}
		return res.isEmpty() ? null : res;
	}

	@Override
	public void remover(Avaliacao avaliacao) {
		avaliacoes.remove(avaliacao);
	}

}
