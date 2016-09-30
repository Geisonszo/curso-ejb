/**
 * 
 */
package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

/**
 * @author Ramon Vieira
 *
 */

@Stateless
public class AutorService {

	@Inject
	private AutorDao autorDao;

	/**
	 * @param autor
	 */
	
	public void adiciona(Autor autor) {
		autorDao.salva(autor);
	}

	/**
	 * @return
	 */
	
	public List<Autor> todosAutores() {
		return autorDao.todosAutores();
	}
	
	
}
