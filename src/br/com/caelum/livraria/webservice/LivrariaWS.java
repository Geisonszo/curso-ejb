/**
 * 
 */
package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

/**
 * @author Ramon Vieira
 *
 */

@Stateless
@WebService
public class LivrariaWS {
	
	@Inject
	private LivroDao livroDao;
	
	@WebResult(name="Autores")
	public List<Livro> getLivrosPorTitulo(@WebParam(name="titulo") String titulo) {
		return livroDao.livrosPeloTitulo(titulo);
	}

}
