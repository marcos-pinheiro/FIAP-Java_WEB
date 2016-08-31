package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;


@WebServlet(urlPatterns = "/admin/cadusuarios")
public class ServletCadastroUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletCadastroUsuarios() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadUsuarios.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
		
		final String nome = request.getParameter("usuario");
		final String senha	 = request.getParameter("senha");
		final Integer nivel	 = Integer.parseInt(request.getParameter("nivel"));
		
		try {
			dao.adicionar(new Usuario(nome, senha, nivel));
			request.setAttribute("mensagem", "Usuário incluido com exito");
		} 
		catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
		}
		
		request.getRequestDispatcher("cadUsuarios.jsp").forward(request, response);
	}

}
