package br.com.fiap.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/sinopse")
public class ServletPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletPDF() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream outputStream = null;
		BufferedInputStream buffer = null;
		
		final String codigo = request.getParameter("codigo");
		
		try {
			outputStream = response.getOutputStream();
			
			File pdf = new File("C:\\Users\\rm30366\\repositorios\\fiap\\java_web\\AplicacaoServletJSP\\" + codigo + ".pdf");
			if(! pdf.exists()) {
				pdf = new File("C:\\Users\\rm30366\\repositorios\\fiap\\java_web\\AplicacaoServletJSP\\geral.pdf");
			}
			
			response.setContentType("application/pdf");
			FileInputStream inputStream = new FileInputStream(pdf);
			buffer = new BufferedInputStream(inputStream);
			
			int bytes;
			while((bytes = buffer.read()) != -1) {
				outputStream.write(bytes);
			}			
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
		finally {
			if(outputStream != null) {outputStream.close();}
			if(buffer != null) {buffer.close();}
		}
	}

}
