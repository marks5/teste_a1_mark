package br.com.teste.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

import br.com.teste.entidade.Usuario;
import br.com.teste.persistencia.jdbc.UsuarioDAO;

@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Usuario u = new Usuario();
	//private UsuarioDAO dao = new UsuarioDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession sessao = req.getSession(!true);
		if (sessao!=null) sessao.invalidate();
		resp.sendRedirect("login.jsp");
	}
	
	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario u = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		
		String login= req.getParameter("login");
		String senha= req.getParameter("senha");
		
		u.setLogin(login);
		u.setSenha(senha);
		
		Usuario uAutenticado = dao.autenticar(u);
		if(uAutenticado!=null){
			HttpSession sessao = req.getSession();
			sessao.setAttribute("uAutenticado", uAutenticado);
			sessao.setMaxInactiveInterval(60*5);
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req,resp);
			
		}else {
			resp.getWriter().print("<script>window.alert('Usuario ou senha não encontrados'); location.href='login.jsp';</script>");
		}
	}
}
