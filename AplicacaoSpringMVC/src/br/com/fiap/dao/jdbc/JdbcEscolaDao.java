package br.com.fiap.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.entity.Escola;

public class JdbcEscolaDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	//Inject by spring
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void incluirEscola(Escola escola) throws Exception {
		final String query = "INSERT INTO ESCOLA (DESCRICAO, ENDERECO, DATAFUNDACAO)";
		try {
			jdbcTemplate.update(query, escola.getDescricao(), escola.getEndereco(), escola.getDataFundacao());
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Escola buscaEscola(int id) throws Exception {
		final String query = "SELECT * FROM ESCOLA WHERE ID = ?";
		Escola escola = null;
		try {
			escola = jdbcTemplate.queryForObject(query, new Integer[]{id}, new EscolaMapper());
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return escola;
	}

	public List<Escola> listarEscolas() throws Exception {
		List<Escola> escolas = new ArrayList<>();
		try {
			escolas = jdbcTemplate.query("SELECT * FROM ESCOLA", new EscolaMapper());
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return escolas;
	} 	
}
