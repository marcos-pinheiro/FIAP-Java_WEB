package br.com.fiap.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.entity.Usuario;

@WebFilter("/admin/*")
public final class FilterLogin implements Filter {

    public FilterLogin() {
    	
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		final HttpSession session = ((HttpServletRequest) request).getSession();
		final Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse)response).sendRedirect("/AplicacaoServletJSP/login.jsp");
		}
	}

	public void init(FilterConfig config) throws ServletException {
		
	}
	
	public void destroy() {
		
	}

}
