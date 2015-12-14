package br.com.teste.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.entidade.Usuario;
import br.com.teste.persistencia.jdbc.UsuarioDAO;

@WebServlet("/uController.do")
public class UsuarioController extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		System.out.println("Construiu");
	}
	
	@Override
		public void init() throws ServletException {
			System.out.println("Init...");
			super.init();
		}
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
	resp.setContentType("text/html");
	String acao = req.getParameter("acao");
	
	
	if(acao.equals("exc")){
		String id = req.getParameter("id");
		Usuario u = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
			if (id!=null) u.setIdAluno(Integer.parseInt(id));
		dao.excluir(u);
		
		resp.sendRedirect("uController.do?acao=list");
	
}else if(acao.equals("list")){
	UsuarioDAO dao = new UsuarioDAO();
	List<Usuario> lista = dao.buscarTodos();
	req.setAttribute("lista", lista);
	RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ulista.jsp");
	dispatcher.forward(req, resp);
	
	} else if(acao.equals("alt")){
		String id = req.getParameter("id");
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorId(Integer.parseInt(id));
		req.setAttribute("usu", usuario);
		req.setAttribute("senha", usuario.getSenha());
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/formUsuario.jsp");
		rd.forward(req, resp);
		
	} else if(acao.equals("cad")){
		Usuario u = new Usuario();
		u.setCpf("");u.setIdAluno(0);u.setLogin("");u.setNome("");u.setSenha("");
		req.setAttribute("usu", u);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/formUsuario.jsp");
		rd.forward(req, resp);
	}
	
}
	


@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	String nome = req.getParameter("nome");
	String login = req.getParameter("login");
	String senha = req.getParameter("senha");
	String cpf = req.getParameter("cpf");
	
	Usuario u = new Usuario();
	UsuarioDAO dao = new UsuarioDAO();
	if(id!=null)u.setIdAluno(Integer.parseInt(id));
	u.setLogin(login);
	u.setCpf(cpf);
	u.setNome(nome);
	u.setSenha(senha);
	dao.salvar(u);
	resp.sendRedirect("uController.do?acao=list");
	System.out.println("salvou");
	
	}


}
