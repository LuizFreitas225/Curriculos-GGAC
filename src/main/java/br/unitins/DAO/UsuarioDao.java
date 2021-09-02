package br.unitins.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.unitins.curriculoggp.model.Usuario;

public class UsuarioDao implements DAO<Usuario> {
    
	
	public UsuarioDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CurriculoGGP");
	EntityManager em  = emf.createEntityManager();
	
	@Override
	public Usuario inserir (Usuario obj) {
		em.getTransaction().begin();
		Usuario aux = em.merge(obj);
		em.getTransaction().commit();
		
		return aux;
	}

	@Override
	public void deletar(Usuario obj) {
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
		
	}

	@Override
	public Usuario atualizar(Usuario obj) {
		Usuario aux = buscar( obj.getId());
		
		em.getTransaction().begin();
		if ( aux.getDescricao() != obj.getDescricao()) {
			aux.setDescricao(obj.getDescricao());
		}
		if ( aux.getNome() != obj.getNome()) {
			aux.setNome(obj.getNome());
		}
		if ( aux.getSenha() != obj.getSenha()) {
			aux.setSenha(obj.getSenha());
		}
		
		
		em.getTransaction().commit();
		
		return aux;
		
	}

	@Override
	public Usuario buscar(Integer id) {
		
		return em.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> buscarTodos() {
		TypedQuery<Usuario> consulta = em.createQuery("SELECT user FROM Usuario user", Usuario.class );
		return consulta.getResultList();
	}
	

}
