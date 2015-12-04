package br.unb.cic.imdb.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TRABALHO_ARTISTICO")
public class TrabalhoArtistico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private String titulo;
	
	@Column
	private int ano;
	
	@ManyToOne
	private Genero genero;
	
	@ManyToOne
	private Autor autor;
	
	@OneToMany(mappedBy="trabalhoArtistico")
	private List<Avaliacao> avaliacoesRecebidas;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	//public void adicionaAvaliacaoRecebida(Avaliacao avaliacao) {
	//	avaliacoesRecebidas.add(avaliacao);
	//}
	
	//public List<Avaliacao> getAvaliacoesRecebidas() {
	//	return avaliacoesRecebidas;
	//}

	//public void setAvaliacoesRecebidas(List<Avaliacao> avaliacoesRecebidas) {
	//	this.avaliacoesRecebidas = avaliacoesRecebidass;
	//}
}
