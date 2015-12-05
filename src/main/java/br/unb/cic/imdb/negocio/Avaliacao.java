package br.unb.cic.imdb.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_AVALIACAO")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int avaliacao;
	
	@Column
	private String comentario;
	
	@ManyToOne
	private Usuario avaliador;
	
	@ManyToOne
	private TrabalhoArtistico avaliado;
	
	public Avaliacao() { }

	public Avaliacao(int avaliacao, String comentario, Usuario avaliador, TrabalhoArtistico avaliado) {
		this.avaliacao = avaliacao;
		this.comentario = comentario;
		this.avaliador = avaliador;
		this.avaliado = avaliado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Usuario avaliador) {
		this.avaliador = avaliador;
	}

	public TrabalhoArtistico getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(TrabalhoArtistico avaliado) {
		this.avaliado = avaliado;
	}
		
}
