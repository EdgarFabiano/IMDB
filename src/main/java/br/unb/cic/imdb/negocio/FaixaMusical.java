package br.unb.cic.imdb.negocio;

public class FaixaMusical {
	private String titulo;
	
	private int duracao;
	
	public FaixaMusical(){ }
	
	public FaixaMusical(String titulo, int duracao){
		this.titulo = titulo;
		this.duracao = duracao;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	
}
