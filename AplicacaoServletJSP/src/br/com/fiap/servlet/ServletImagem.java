package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

@WebServlet("/admin/imagem")
public class ServletImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletImagem() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenericDao<Livro> dao = new GenericDao<>(Livro.class);
		byte[] imagem = dao.buscar(Integer.parseInt(request.getParameter("codigo"))).getImagem();
		
		response.setContentType("imagem/jpeg");
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(imagem);
		outputStream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
