package br.com.fiap.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

@WebServlet(urlPatterns = "/admin/cadlivros")
@MultipartConfig
public class ServletCadastroLivros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastroLivros() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadLivros.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			final GenericDao<Livro> dao = new GenericDao<>(Livro.class);
			
			final String codigo = request.getParameter("codigo");
			final String titulo	= request.getParameter("titulo");
			final String autor	= request.getParameter("autor");
			final String data	= request.getParameter("data");
			final String preco	= request.getParameter("preco");
			
			final Part filePart = request.getPart("foto"); 
			final byte[] imagem = new byte[(int) filePart.getSize()];
			if(filePart != null) {
				filePart.getInputStream().read(imagem, 0, (int)filePart.getSize());
			}
			
			Livro livro = new Livro();
			livro.setCodigo(Integer.parseInt(codigo));
			livro.setDataPublicacao(new SimpleDateFormat("dd/MM/yyyy").parse(data));
			livro.setImagem(imagem);
			livro.setPreco(Double.parseDouble(preco));
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			
			dao.adicionar(livro);
			
			request.setAttribute("mensagem", "Livro adicionado com sucesso");
		} 
		catch(Exception e) {
			request.setAttribute("mensagem", e.getMessage());
		}
		
		request.getRequestDispatcher("cadLivros.jsp").forward(request, response);		
	}

}
