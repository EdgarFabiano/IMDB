package br.unb.cic.imdb.negocio;

public class Populador {	
	
	public Populador() {}
	/**
	 * SOMENTE UTILIZAR COM A IMPLEMENTACAO EM MEMORIA
	 * (pra usar com JPA retirar os setId)
	 * 
	 * Esse metodo popula o banco de dados com os seguintes itens
	 * Usuarios: 
	 * 	-login:lucas, nome:lucas, senha:senha
	 * 	-login:bruno, nome:bruno, senha:senha
	 * 	-login:edgar, nome:edgar, senha:senha
	 * Autores:
	 * 	-Wesley Safadao
	 * 	-George Lucas
	 * 	-Peter Jackson
	 * 	-Iron Maiden
	 * Generos:
	 * 	-Ficcao Cientifica
	 * 	-Aventura
	 * 	-Rock
	 * 	-Forro
	 * Albums:
	 * 	-Wesley 1
	 * 	-Wesley 2
	 * 	-Iron 1
	 * 	-Iron 2
	 * Filmes:
	 * 	-Star Wars IV
	 * 	-Star Wars V
	 * 	-Star Wars VI
	 * 	-Senhor dos Aneis 1
	 * 	-Senhor dos Aneis 2
	 * 	-Senhor dos Aneis 3
	 * Faixas Musicais:
	 * 	-Vai Safadao (Wesley 1)
	 * 	-Camarote (Wesley 1)
	 * 	-Voce Merece Cache (Wesley 2)
	 * 	-Vou Pagar pra Ver (Wesley 2)
	 * 	-Powerslave (Iron 1)
	 * 	-Fear of the Dark (Iron 1)
	 * 	-The Trooper (Iron 2)
	 * 	-Brave New World (Iron 2)
	 * 
	 * Nao criei avaliacoes mas depois eh tranquilo de adicionar por aqui
	 * Soh dar um new com os parametros la e mandar salvar no DAO e GG
	 */
	public void popular (IMDBFacade facade) {
		Usuario usuario1 = new Usuario("bruno", "senha", "bruno");
//		usuario1.setId((long) 1);
		facade.adicionaUsuario(usuario1);
		Usuario usuario2 = new Usuario("edgar", "senha", "edgar");
//		usuario2.setId((long) 2);
		facade.adicionaUsuario(usuario2);
		Usuario usuario3 = new Usuario("lucas", "senha", "lucas");
//		usuario3.setId((long) 3);
		facade.adicionaUsuario(usuario3);
		
		Autor autor1 = new Autor("Wesley Safadao", "O SafaRei");
//		autor1.setId((long) 1);
		facade.adicionaAutor(autor1);
		Autor autor2 = new Autor("George Lucas", "Grande George");
//		autor2.setId((long) 2);
		facade.adicionaAutor(autor2);
		Autor autor3 = new Autor("Peter Jackson", "Saudoso Peter");
//		autor3.setId((long) 3);
		facade.adicionaAutor(autor3);
		Autor autor4 = new Autor("Iron Maiden", "Banda maneira");
//		autor4.setId((long) 4);
		facade.adicionaAutor(autor4);
		
		Genero genero1 = new Genero("Ficcao Cientifica", "Aquele com os laser la");
//		genero1.setId((long) 1);
		facade.adicionaGenero(genero1);
		Genero genero2 = new Genero("Aventura", "Aquele com as espada la");
//		genero2.setId((long) 2);
		facade.adicionaGenero(genero2);
		Genero genero3 = new Genero("Rock", "Pedra em ingles");
//		genero3.setId((long) 3);
		facade.adicionaGenero(genero3);
		Genero genero4 = new Genero("Forro", "Soh coisa boa");
//		genero4.setId((long) 4);
		facade.adicionaGenero(genero4);
		
		AlbumMusical album1 = new AlbumMusical("Wesley 1", 2013, genero4, autor1);
//		album1.setId((long) 1);
		facade.adicionaTrabalhoArtistico(album1);
		AlbumMusical album2 = new AlbumMusical("Wesley 2", 2015, genero4, autor1);
//		album2.setId((long) 2);
		facade.adicionaTrabalhoArtistico(album2);
		AlbumMusical album3 = new AlbumMusical("Iron 1", 2010, genero3, autor4);
//		album3.setId((long) 3);
		facade.adicionaTrabalhoArtistico(album3);
		AlbumMusical album4 = new AlbumMusical("Iron 2", 2014, genero3, autor4);
//		album4.setId((long) 4);
		facade.adicionaTrabalhoArtistico(album4);
		
		Filme filme1 = new Filme("Star Wars IV", 1977, genero1, autor2, 180);
//		filme1.setId((long) 5);
		facade.adicionaTrabalhoArtistico(filme1);
		Filme filme2 = new Filme("Star Wars V", 1980, genero1, autor2, 180);
//		filme2.setId((long) 6);
		facade.adicionaTrabalhoArtistico(filme2);
		Filme filme3 = new Filme("Star Wars VI", 1983, genero1, autor2, 180);
//		filme3.setId((long) 7);
		facade.adicionaTrabalhoArtistico(filme3);
		Filme filme4 = new Filme("Senhor dos Aneis 1", 2001, genero2, autor3, 180);
//		filme4.setId((long) 8);
		facade.adicionaTrabalhoArtistico(filme4);
		Filme filme5 = new Filme("Senhor dos Aneis 2", 2002, genero2, autor3, 180);
//		filme5.setId((long) 9);
		facade.adicionaTrabalhoArtistico(filme5);
		Filme filme6 = new Filme("Senhor dos Aneis 3", 2003, genero2, autor3, 180);
//		filme6.setId((long) 10);
		facade.adicionaTrabalhoArtistico(filme6);
		
		FaixaMusical faixa1 = new FaixaMusical(album1, "Vai Safadao", 2);
//		faixa1.setId((long) 1);
		facade.adicionarFaixaMusical(faixa1);
		FaixaMusical faixa2 = new FaixaMusical(album1, "Camarote", 2);
//		faixa2.setId((long) 2);
		facade.adicionarFaixaMusical(faixa2);
		FaixaMusical faixa3 = new FaixaMusical(album2, "Voce Merece Cache", 2);
//		faixa3.setId((long) 3);
		facade.adicionarFaixaMusical(faixa3);
		FaixaMusical faixa4 = new FaixaMusical(album2, "Vou Pagar pra Ver", 2);
//		faixa4.setId((long) 4);
		facade.adicionarFaixaMusical(faixa4);
		FaixaMusical faixa5 = new FaixaMusical(album3, "Powerslave", 2);
//		faixa5.setId((long) 5);
		facade.adicionarFaixaMusical(faixa5);
		FaixaMusical faixa6 = new FaixaMusical(album3, "Fear of the Dark", 2);
//		faixa6.setId((long) 6);
		facade.adicionarFaixaMusical(faixa6);
		FaixaMusical faixa7 = new FaixaMusical(album4, "The Trooper", 2);
//		faixa7.setId((long) 7);
		facade.adicionarFaixaMusical(faixa7);
		FaixaMusical faixa8 = new FaixaMusical(album4, "Brave New World", 2);
//		faixa8.setId((long) 8);
		facade.adicionarFaixaMusical(faixa8);
	}

}
