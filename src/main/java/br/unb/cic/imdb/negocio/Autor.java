package br.unb.cic.imdb.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_AUTOR")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_autor")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	@OneToMany(mappedBy="autor")
	private List<TrabalhoArtistico> producaoArtistica;
	
	public Autor() { }
	
	public Autor(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao; 
		this.producaoArtistica = null;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void adicionaTrabalhoArtistico(TrabalhoArtistico contribuicao) {
		producaoArtistica.add(contribuicao);
	}
	public List<TrabalhoArtistico> getProducaoArtistica() {
		return producaoArtistica;
	}

	public void setProducaoArtistica(List<TrabalhoArtistico> producaoArtistica) {
		this.producaoArtistica = producaoArtistica;
	}
	
	
}
