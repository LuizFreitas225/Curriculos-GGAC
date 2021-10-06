package br.unitins.curriculoggac.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	
	private static EntityManagerFactory emf = 
			  Persistence.createEntityManagerFactory("CurriculoGGP");
	
	private JPAUtil() {	}
	
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
