package br.unitins.curriculoggac.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {

	@SuppressWarnings("unchecked")
	public List<Usuario> findByNome(String nome) throws RepositoryException {
		try {
			EntityManager em = getEntityManager();
			// JPQL ou SQL
			Query query = em.createQuery("SELECT u FROM Usuario u WHERE upper(u.primeiroNome) LIKE upper(:nome)");
			query.setParameter("nome", "%" + nome + "%");

			return query.getResultList();
		} catch (Exception e) {
			// mandando pro console o exception gerado
			e.printStackTrace();
			// repassando a excecao para quem vai executar o metodo
			throw new RepositoryException("Problema ao pesquisar usuários.");
		}
	}

//	public List<Usuario> findByEmail(String email) throws RepositoryException {
//		try {
//			EntityManager em = getEntityManager();
//			// JPQL ou SQL
//			Query query = em.createNativeQuery("SELECT * FROM usuario u WHERE u.email = :email");
//			query.setParameter("email", email);
//
//			return query.getResultList();
//		} catch (Exception e) {
//			// mandando pro console o exception gerado
//			e.printStackTrace();
//			// repassando a excecao para quem vai executar o metodo
//			throw new RepositoryException("Problema ao pesquisar usuários.");
//		}
//	}

	public Usuario findById(String id) throws RepositoryException {
		try {
			EntityManager em = getEntityManager();
			return em.find(Usuario.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Problema ao pesquisar usuário.");
			
		}
		
		
	}

	public Usuario atualizar(Usuario obj) throws RepositoryException {
		try {
			EntityManager em = getEntityManager();

			Usuario aux = findById(obj.getEmail());

			em.getTransaction().begin();
			if (aux.getNome() != obj.getNome()) {
				aux.setNome(obj.getNome());
			}
			if (aux.getSenha() != Util.hash(aux.getEmail() + aux.getSenha())) {
				aux.setSenha(obj.getSenha());
			}
			if (aux.getEmail() != obj.getEmail()) {
				aux.setEmail(obj.getEmail());
			}

			em.getTransaction().commit();

			return aux;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Problema ao atualizar usuário.");
		}

	}

	@Override
	public Usuario save(Usuario entity) throws RepositoryException {
		try {
			String hash = Util.hash(entity.getEmail() + entity.getSenha());
			entity.setSenha(hash);
			getEntityManager().getTransaction().begin();
			Usuario e = getEntityManager().merge(entity);
			getEntityManager().getTransaction().commit();
			return e;
		} catch (Exception e) {
			System.out.println("Erro ao executar o save");
			e.printStackTrace();
			throw new RepositoryException("Erro ao Salvar");
		}
	}

	public Usuario validarLogin(String email, String senha) throws RepositoryException {
		Usuario usuarioLogado = null;
		try {

			usuarioLogado = findById(email);
			if( usuarioLogado == null) {
				return null;
			}else {
				
			   if(usuarioLogado.getSenha().equals(Util.hash(email + senha))) {	
				   return usuarioLogado;
			   }else {
				   return null;
			   }
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao logar.");
			
		}
		
		
	}
}