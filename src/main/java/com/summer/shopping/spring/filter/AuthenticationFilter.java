package com.summer.shopping.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

@WebFilter("/")
public class AuthenticationFilter implements Filter {
	private static Log LOG = LogFactory.getLog(AuthenticationFilter.class);
	@Override
	  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	      throws IOException, ServletException {
	    LOG.debug("COME ON Filter~~~~~~~~~~~~~~~~~~");
	    chain.doFilter(req, res);
	  }

	  @Override
	  public void init(FilterConfig config) throws ServletException {
	    
	  }

	  @Override
	  public void destroy() {

	  }
}
