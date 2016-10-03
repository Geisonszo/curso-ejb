package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

/**
 * @author Ramon Vieira
 *
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
//@Interceptors({LogInterceptador.class})
public class AutorDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	void inicialize(){
		System.out.println("[INFO] - AutorDao foi inicializado.");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salva(Autor autor) {
		System.out.println("[INFO] Salvando o Autor " + autor.getNome());

//	    try {
//	        Thread.sleep(20000);    // 20 segundos
//	    } catch (InterruptedException e) {
//	        e.printStackTrace();
//	    }

		entityManager.persist(autor);
	    System.out.println("[INFO] Salvou o Autor " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return entityManager.find(Autor.class, autorId);
	}
	
}
