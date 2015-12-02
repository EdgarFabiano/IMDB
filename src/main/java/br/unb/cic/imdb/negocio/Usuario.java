package br.unb.cic.imdb.negocio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Usuario {
	
	private Long id;
	
	private String login;
	
	private String senha;
	
	private String nome;
	
	private Calendar nascimento;
	
	//private List<Avaliacao> avaliacoesFeitas;
	
	public Usuario(String login, String senha, String nome){
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		//this.avaliacoesFeitas = null;
	}
	
	public Usuario(String login, String senha, String nome, int anoNascimento, int mesNascimento, int diaNascimento){
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		//this.avaliacoesFeitas = null;
		setNascimento(anoNascimento, mesNascimento, diaNascimento);
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getNascimento() {
		return nascimento.getTime();
	}
	
	public void setNascimento(Date data) {
		this.nascimento.setTime(data);
	}
	
	//Caso queira setar o nascimento direto pelo dia, mes e ano.
	public void setNascimento(int ano, int mes, int dia) {
		this.nascimento.set(ano, mes, dia);
	}
	
	//public void adicionaAvaliacaoFeita(Avaliacao avaliacao) {
	//	avaliacoesFeitas.add(avaliacao);
	//}
	
	//public List<Avaliacao> getAvaliacoesFeitas() {
	//	return avaliacoesFeitas;
	//}

	//public void setAvaliacoesFeitas(List<Avaliacao> avaliacoesFeitas) {
	//	this.avaliacoesFeitas = avaliacoesFeitas;
	//}
}
