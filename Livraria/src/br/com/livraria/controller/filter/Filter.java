package br.com.livraria.controller.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.livraria.model.database.connection.SingleConnectionPostgre;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns= {"/*"})
public class Filter implements javax.servlet.Filter {
	
	private static Connection connection;

    /**
     * Método Construtor 
     */
    public Filter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * Método de interceptador de requisições
	 */
	public void doFilter(ServletRequest request, 
			ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		try {
		chain.doFilter(request, response);
		
		connection.commit();
		
		}catch(Exception e1) {
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		connection = SingleConnectionPostgre.getConnection();
	}

}
