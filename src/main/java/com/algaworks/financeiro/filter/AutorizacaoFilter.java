package com.algaworks.financeiro.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algaworks.financeiro.model.Usuario;

@WebFilter("*.xhtml")
public final class AutorizacaoFilter implements Filter {
	
	@Inject
	private Usuario usuario;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req; 
		HttpServletResponse response = (HttpServletResponse) res;
		
		if (!usuario.isLogado() &&
				!request.getRequestURI().endsWith("Login.xhtml") &&
				!request.getRequestURI().contains("javax.faces.resource") ) {
			response.sendRedirect(request.getContextPath() + "/Login.xhtml");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
