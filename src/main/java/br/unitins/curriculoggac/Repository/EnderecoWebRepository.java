package br.unitins.curriculoggac.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.EnderecoWeb;

public class EnderecoWebRepository extends Repository<EnderecoWeb> {
	
	//Busca Todos os endereçõs vínculados  a um determinado currículo
	@SuppressWarnings("unchecked")
	public List<EnderecoWeb> findByDescricao(String descricao,  Curriculo curriculo) throws RepositoryException {
		try { 
			EntityManager em = getEntityManager();
			//JPQL ou SQL
			Query query = em.createQuery("SELECT c FROM EnderecoWeb c " + 
					"WHERE upper(c.descricao) like upper(:nome)" + 
					"AND :pessoa = c.pessoa ORDER BY c.descricao" , EnderecoWeb.class);
			query.setParameter("nome", "%" + descricao + "%");
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
