package br.com.fiap.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import br.com.fiap.dao.Dao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

@Results({
	@Result(name = "ok", 	location = "/menu.jsp"),
	@Result(name = "error",	location = "/error.jsp"),
	@Result(name = "input", location = "/cadLivros.jsp")
})
public class LivroAction extends ActionSupport {

	private File figura;
	private Livro livro;
	private List<Livro> livros;
	
	public LivroAction() {
		super();
	}

	@Action(value = "/cadastro")
	public String incluir() {
		
		try {
			final InputStream stream = new FileInputStream(figura);
			byte[] imagem = new byte[(int) figura.length()];
			stream.read(imagem, 0, (int)figura.length());
			
			livro.setImagem(imagem);
			
			Dao<Livro> dao = new GenericDao<>(Livro.class);
			dao.adicionar(livro);
			
			return "input";
		}
		catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}

	public File getFigura() {
		return figura;
	}
	
	public void setFigura(File figura) {
		this.figura = figura;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	private static final long serialVersionUID = 1L;
}
