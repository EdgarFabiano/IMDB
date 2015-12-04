package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Avaliacao;

public interface DAOAvaliacao {

	public void salvar(Avaliacao avaliacao);
	public List<Avaliacao> recuperaTodos();
	//Vamos ter que recuperar avaliacao de alguma forma mais especifica?
	//Toda vez que usuario e trabalho artistico forem recuperados já trarão
	//consigo a lista de avaliacoes referentes a ele, o unico criterio a mais
	//pensar eh buscar avaliacoes por nota mas n sei se faz mto sentido.
	//O que vcs acham?
}
