package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

/**
 * @author Ramon Vieira
 *
 */

@Model
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject
	private AutorDao dao;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		dao.salva(autor);
		autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return dao.todosAutores();
	}
}
