package br.unb.cic.imdb.negocio;

import java.util.List;

public class AlbumMusical extends TrabalhoArtistico{
	private List<FaixaMusical> faixasMusicais;
	
	public AlbumMusical(){ }
	
	public AlbumMusical(String titulo, int ano, Genero genero, Autor autor){
		super(titulo, ano, genero, autor);
		this.faixasMusicais = null;
	}
	
	public void adicionaFaixaMusical(FaixaMusical faixa) {
		faixasMusicais.add(faixa);
	}
	
	public List<FaixaMusical> getFaixasMusicais() {
		return faixasMusicais;
	}

	public void setFaixasMusicais(List<FaixaMusical> faixasMusicais) {
		this.faixasMusicais = faixasMusicais;
	}
}
