package br.com.fiap.bean;

import java.util.Collections;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

public class LivrosBean {
	
	public List<Livro> getListaLivros() {
		
		List<Livro> livros = Collections.emptyList();		
		
		GenericDao<Livro> dao = new GenericDao<>(Livro.class);
		livros = dao.listar();
		
		return livros;
	}
	
}
