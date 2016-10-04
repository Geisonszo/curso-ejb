/**
 * 
 */
package br.com.caelum.livraria.schedule;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

/**
 * @author Ramon Vieira
 *
 */

@Singleton
@Startup
public class ListaLivrosJob {

	@Inject
	private LivroDao livroDao;
	
	@Schedule(hour="*", minute="*", second="*/5")
	private void exibeListaLivros(){

		System.out.println("Listando livros cadastrados...");
		
		for (Livro livro : livroDao.todosLivros()) {
			System.out.println(livro.getAutor().getNome());
			System.out.println(livro.getTitulo());
		}
		
		System.out.println("A lista atualizada irá ser exibida daqui a 5 segundos...");
		
	}
	
}
