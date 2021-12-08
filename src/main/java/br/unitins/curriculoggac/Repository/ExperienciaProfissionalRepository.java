package br.unitins.curriculoggac.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.ExperienciaProfissional;

public class ExperienciaProfissionalRepository extends Repository<ExperienciaProfissional>  {
	
	
	
	public List<ExperienciaProfissional> findByNome(String nome, Curriculo curriculo) throws RepositoryException {
		try { 
			EntityManager em = getEntityManager();
			//JPQL ou SQL
			Query query = em.createQuery("SELECT c FROM ExperienciaProfissional c " + 
					"WHERE upper(c.cargo) like upper(:cargo)" + 
					"AND :pessoa = c.pessoa ORDER BY c.cargo" , ExperienciaProfissional.class);
			query.setParameter("cargo", "%" + nome + "%");
			query.setParameter("pessoa", curriculo.getPessoa());
		
			
			
			return query.getResultList();
		} catch (Exception e) {
			// mandando pro console o exception gerado
			e.printStackTrace();
			// repassando a excecao para quem vai executar o metodo
			throw new RepositoryException("Problema ao pesquisar curr�culos.");
		}
	}
}