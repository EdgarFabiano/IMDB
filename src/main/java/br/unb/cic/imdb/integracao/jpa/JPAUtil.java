package br.unb.cic.imdb.integracao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManagerFactory emf = null;
	public static EntityManager em = null;

	public static void comecarOperacoes() {
		emf = Persistence.createEntityManagerFactory("imdb");
		em = emf.createEntityManager();
		
	}

	public static void finalizarOperacoes() {
		em.close();
		emf.close();
	}
}
