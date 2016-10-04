package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

/**
 * @author Ramon Vieira
 *
 */

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salva(Livro livro) {
		entityManager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return entityManager.createQuery("select l From Livro l",Livro.class).getResultList();
	}

	/**
	 * @param titulo
	 * @return
	 */
	public List<Livro> livrosPeloTitulo(String titulo) {
		
		TypedQuery<Livro> query = entityManager.createQuery("select l From Livro l where l.titulo like :titulo",Livro.class);
		query.setParameter("titulo", "%" +titulo+ "%");
		
		return query.getResultList();
	}
	
}
