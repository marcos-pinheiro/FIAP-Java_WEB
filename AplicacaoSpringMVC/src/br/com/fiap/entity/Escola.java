package br.com.fiap.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Escola {
	
	private int id;
	private String descricao;
	private String endereco;
	private Date dataFundacao;
	private List<Curso> cursos = new ArrayList<>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public void setDataFundacao(String data) {
		final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			this.setDataFundacao(format.parse(data));
		} 
		catch (ParseException e) {
			this.setDataFundacao(new Date());
		}	
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
