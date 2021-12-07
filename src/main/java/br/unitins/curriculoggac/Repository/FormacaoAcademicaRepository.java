package br.unitins.curriculoggac.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.FormacaoAcademica;


public class FormacaoAcademicaRepository extends Repository<FormacaoAcademica>  {
	
	
	
	public List<FormacaoAcademica> findByNome(String nome, Curriculo curriculo) throws RepositoryException {
		try { 
			EntityManager em = getEntityManager();
			//JPQL ou SQL
			Query query = em.createQuery("SELECT c FROM FormacaoAcademica c " + 
					"WHERE upper(c.nome) like upper(:nome)" + 
					"AND :pessoa = c.pessoa ORDER BY c.nome" , FormacaoAcademica.class);
			query.setParameter("nome", "%" + nome + "%");
			query.setParameter("pessoa", curriculo.getPessoa());
		
			
			
			return query.getResultList();
		} catch (Exception e) {
			// mandando pro console o exception gerado
			e.printStackTrace();
			// repassando a excecao para quem vai executar o metodo
			throw new RepositoryException("Problema ao pesquisar currículos.");
		}
	}
}
