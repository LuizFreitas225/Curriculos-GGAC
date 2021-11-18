package br.unitins.curriculoggac.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.Usuario;


public class CurriculoRepository extends Repository<Curriculo> {
	@SuppressWarnings("unchecked")
	public List<Curriculo> findByDescricao(String descricao) throws RepositoryException {
		try {
			EntityManager em = getEntityManager();
			// JPQL ou SQL
			Query query = em.createQuery("SELECT u FROM Curriculo u WHERE upper(u.descricao) LIKE upper(:descricao)");
			query.setParameter("descricao", "%" + descricao + "%");

			return query.getResultList();
		} catch (Exception e) {
			// mandando pro console o exception gerado
			e.printStackTrace();
			// repassando a excecao para quem vai executar o metodo
			throw new RepositoryException("Problema ao pesquisar currículos.");
		}
	}
	

	@SuppressWarnings("unchecked")
	public List<Curriculo> findByDescricao(String descricao, Integer maxResults, Usuario usuario) throws RepositoryException {
		try { 
			EntityManager em = getEntityManager();
			//JPQL ou SQL
			Query query = em.createQuery("SELECT c FROM Curriculo c "
					+ "WHERE upper(c.descricao) LIKE upper(:descricao) "
					+ " AND :usuario = c.usuario  "
					+ "ORDER BY c.descricao");
			query.setParameter("descricao", "%" + descricao + "%");
			query.setParameter("usuario", usuario);
			if (maxResults != null)
				query.setMaxResults(maxResults);
			
			return query.getResultList();
		} catch (Exception e) {
			// mandando pro console o exception gerado
			e.printStackTrace();
			// repassando a excecao para quem vai executar o metodo
			throw new RepositoryException("Problema ao pesquisar currículos.");
		}
	}

}
