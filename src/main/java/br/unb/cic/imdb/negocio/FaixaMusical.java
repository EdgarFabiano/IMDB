package br.unb.cic.imdb.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_FAIXA_MUSICAL")
public class FaixaMusical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private AlbumMusical album;
	
	@Column
	private String titulo;
	
	@Column
	private int duracao;
	
	public FaixaMusical(){ }
	
	public FaixaMusical(AlbumMusical album, String titulo, int duracao) {
		this.album = album;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AlbumMusical getAlbum() {
		return album;
	}

	public void setAlbum(AlbumMusical album) {
		this.album = album;
	}
		
}
