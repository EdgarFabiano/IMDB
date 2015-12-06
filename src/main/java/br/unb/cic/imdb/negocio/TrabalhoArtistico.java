package br.unb.cic.imdb.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TRABALHO_ARTISTICO")
@Inheritance
public class TrabalhoArtistico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_trabalho_artistico")
	private Long id; 
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="ano")
	private int ano;
	
	@ManyToOne
	@JoinColumn(name="id_genero", referencedColumnName="id_genero")
	private Genero genero;
	
	@ManyToOne
	@JoinColumn(name="id_autor", referencedColumnName="id_autor")
	private Autor autor;
	
	@OneToMany(mappedBy="avaliado")
	private List<Avaliacao> avaliacoesRecebidas;

	public TrabalhoArtistico() { }
	
	public TrabalhoArtistico(String titulo, int ano, Genero genero, Autor autor) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.autor = autor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public void adicionaAvaliacaoRecebida(Avaliacao avaliacao) {
		avaliacoesRecebidas.add(avaliacao);
	}
	
	public List<Avaliacao> getAvaliacoesRecebidas() {
		return avaliacoesRecebidas;
	}

	public void setAvaliacoesRecebidas(List<Avaliacao> avaliacoesRecebidas) {
		this.avaliacoesRecebidas = avaliacoesRecebidas;
	}
}
