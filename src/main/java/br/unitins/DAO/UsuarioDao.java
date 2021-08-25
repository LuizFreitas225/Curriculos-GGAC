package br.unitins.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.curriculoggp.model.Usuario;

public class UsuarioDao implements DAO<Usuario> {
    
	
	public UsuarioDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CurriculoGGP");
	EntityManager em  = emf.createEntityManager();
	
	@Override
	public void inserir(Usuario obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}
	

}
