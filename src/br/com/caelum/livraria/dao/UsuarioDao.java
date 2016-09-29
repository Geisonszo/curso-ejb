package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

/**
 * @author Ramon Vieira
 *
 */

@Stateless
public class UsuarioDao {

	@PersistenceContext	
	private EntityManager entityManager;

	public Usuario buscaPeloLogin(String login) {
		return entityManager.createQuery("select u From Usuario u where login = :login", Usuario.class).
				setParameter("login", login).
				getSingleResult();
	}
	
}
