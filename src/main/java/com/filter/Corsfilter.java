package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class Corsfilter implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException{
		
	}
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain) throws IOException ,ServletException{
		HttpServletResponse r = (HttpServletResponse) resp;
		r.setHeader("Access-Control-Allow-Origin", "*");
		r.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
		r.setHeader("Access-Control-Max-Age", "3600");
		r.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		chain.doFilter(req, resp);
	}
	
	public void destroy(){
		
	}
}
