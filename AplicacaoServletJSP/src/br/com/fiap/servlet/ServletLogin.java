package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;

@WebServlet(
		urlPatterns = "/valida", 
		initParams = { 
				@WebInitParam(name = "user", value = "admin"), 
				@WebInitParam(name = "pwd", value = "admin")
		})
public class ServletLogin extends HttpServlet {
	
    public ServletLogin() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		final PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<h2>Uachacha</h2>");
		*/
		request.getRequestDispatcher("login.jsp").include(request, response);
		// ou response.sendRedirect("login.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//final String user = super.getServletConfig().getInitParameter("user");
		//final String pwd  = super.getServletConfig().getInitParameter("pwd");
		
		final String login = request.getParameter("usuario");
		final String senha	 = request.getParameter("senha");  	
		
		try {
			GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
			Usuario usuario = dao.buscar(login, senha);
			if(dao.buscar(login, senha) != null) {
				
				final HttpSession session = request.getSession();
				session.setAttribute("usuario", usuario);
				
				response.sendRedirect("admin/menu.jsp");			
			}
			else {
				request.setAttribute("mensagem", "Usuario ou Senha inválidos");
				request.getRequestDispatcher("login.jsp")
						.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("mensagem", "Usuario ou Senha inválidos");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
	}
	
	private static final long serialVersionUID = 1L;
}
