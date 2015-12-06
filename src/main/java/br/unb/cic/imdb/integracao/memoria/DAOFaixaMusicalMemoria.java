package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOFaixaMusical;
import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.FaixaMusical;

public class DAOFaixaMusicalMemoria implements DAOFaixaMusical {

	private List<FaixaMusical> faixasMusicais;
	@Override
	public void salvar(FaixaMusical faixaMusical) {
		faixasMusicais.add(faixaMusical);
	}

	@Override
	public List<FaixaMusical> recuperaTodos() {
		return faixasMusicais;
	}

	@Override
	public List<FaixaMusical> recuperaPorAlbum(AlbumMusical albumMusical) {
		List<FaixaMusical> res = new ArrayList<>();
		for (FaixaMusical faixa : faixasMusicais) {
			if (faixa.getAlbum().equals(albumMusical)) {
				res.add(faixa);
			}
		}
		return res.size() == 0 ? null : res;
	}

	@Override
	public FaixaMusical recuperaPorTitulo(String titulo) {
		for (FaixaMusical faixa : faixasMusicais) {
			if (faixa.getTitulo().equals(titulo)) {
				return faixa;
			}
		}
		return null;
	}

	@Override
	public void remover(FaixaMusical faixaMusical) {
		faixasMusicais.remove(faixaMusical);
	}

}
