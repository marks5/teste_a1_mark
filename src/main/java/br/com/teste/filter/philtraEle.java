package br.com.teste.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
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

@WebFilter(dispatcherTypes={DispatcherType.REQUEST}, urlPatterns="/*")
public class philtraEle implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	//		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		String uri = httpReq.getRequestURI();
		HttpSession sessao = httpReq.getSession(false);
		
		if(sessao!=null || uri.lastIndexOf("login.jsp")!=-1 || uri.lastIndexOf("autenticador.do")!=-1){
			chain.doFilter(request, response);
		}else{
			httpResp.sendRedirect("login.jsp");
		}
		
		System.out.println("passou pelo filtro");
		//chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
