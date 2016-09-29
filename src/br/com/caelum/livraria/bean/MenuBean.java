package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MenuBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer index=0;
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public String paginaLivros() {
		System.out.println("Chamando o paginaLivros()");
		this.index = 0;
		return "livros?faces-redirect=true";
	}
	
	public String paginaAutores() {
		System.out.println("Chamando o paginaAutores()");
		this.index = 1;
		return "autores?faces-redirect=true";
	}

	public String paginaLogin() {
		System.out.println("Chamando o paginaLogin()");
		this.index = 0;
		return "login?faces-redirect=true";
	}
}
