package com.student.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		final HttpServletResponse response = (HttpServletResponse) res;
		final HttpServletRequest request = (HttpServletRequest) req;
		final String authHeader = request.getHeader("authorization");
		
		if("OPTIONS".equals(request.getMethod()))
		{
			response.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(req, res);
		}
		else
		{
			if(authHeader==null || !authHeader.startsWith("Bearer "))
			{
				throw new ServletException("Invalid or missing Authorization.");
			}
			final String token = authHeader.substring(7);
			try {
				
				Claims claims=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
				request.setAttribute("claims", claims);
				
			}
			catch(final SignatureException e)
			{
				throw new ServletException("Invalid Token.");
			}
			
			chain.doFilter(req, res);
		}
		
	}

	

	

}
