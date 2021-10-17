package br.unitins.curriculoggac.Repository.endereco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.curriculoggac.Repository.Repository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.endereco.Estado;


public class EstadoRepository extends Repository<Estado>  {
	   
		@SuppressWarnings("unchecked")
		public List<Estado> findByNome(String nome) throws RepositoryException {
			try {
				EntityManager em = getEntityManager();
				// JPQL ou SQL
				Query query = em.createQuery("SELECT u FROM Estado u WHERE upper(u.nome) LIKE upper(:nome)");
				query.setParameter("nome", "%" + nome + "%");

				return query.getResultList();
			} catch (Exception e) {
				// mandando pro console o exception gerado
				e.printStackTrace();
				// repassando a excecao para quem vai executar o metodo
				throw new RepositoryException("Problema ao pesquisar usuários.");
			}
		}

}
