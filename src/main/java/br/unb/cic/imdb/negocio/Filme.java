package br.unb.cic.imdb.negocio;

public class Filme extends TrabalhoArtistico {
	private int duracao;
	
	public Filme(){ }
	
	public Filme(String titulo, int ano, Genero genero, Autor autor, int duracao){
		super(titulo, ano, genero, autor);
		this.duracao = duracao;
	}
	
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}
