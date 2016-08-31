package br.com.fiap.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.entity.Curso;

public class JdbcCursoDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void incluirCurso(Curso curso) throws Exception {
		final String query = "INSERT INTO CURSOS (ID,IDESCOLA,DESCRICAO) VALUES (?,?,?)";
		try {
			jdbcTemplate.update(query,curso.getId(), curso.getEscola().getId(), curso.getDescricao());
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
