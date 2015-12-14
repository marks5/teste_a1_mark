package br.com.teste;

import java.util.List;

import br.com.teste.entidade.Usuario;
import br.com.teste.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//Alterar();
		//Excluir();
		//Salvar();
		//BuscarId();
		//BuscarTodos();
		Autenticar();
	}

	private static void Autenticar() {
		UsuarioDAO dao = new UsuarioDAO();
		//new Usuario autentica = dao.autenticar(autentica);
		Usuario user = new Usuario();
		user.setLogin("vish");
		user.setSenha("9273");
		Usuario autenticado = dao.autenticar(user);
		if(autenticado!=null){
			System.out.println("Usuario autenticado" +autenticado.toString());
		}else{
			System.out.println("Usuario n autenticado");
		}
		
	}

	private static void BuscarTodos() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.buscarTodos();
		for (Usuario u: lista){
			System.out.println(u);			
		}
		
	}

	private static void BuscarId() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorId(13);
		System.out.println(usuario.toString());
		
	}

	public static void Salvar(){
		Usuario u = new Usuario();
		//u.setIdAluno(12);
		u.setCpf("444554");
		u.setLogin("lokdo");
		u.setNome("Rapad");
		u.setSenha("1245");

		UsuarioDAO UsuarioDao = new UsuarioDAO();
		UsuarioDao.salvar(u);
		
		System.out.println("Salvo c Sucesso");
	}
	
	public static void Excluir(){
		Usuario u = new Usuario();
		u.setIdAluno(12);

		UsuarioDAO UsuarioDao = new UsuarioDAO();
		UsuarioDao.excluir(u);
		
		System.out.println("Excluido c Sucesso");
	}
	
	public static void Alterar(){
		Usuario u = new Usuario();
		u.setIdAluno(12);
		u.setCpf("44444");
		u.setLogin("loko");
		u.setNome("Rapa");
		u.setSenha("121245");

		UsuarioDAO UsuarioDao = new UsuarioDAO();
		UsuarioDao.alterar(u);
		
		System.out.println("Alterado c Sucesso");
	}

	
	public static void Cadastrar(){
		Usuario u = new Usuario();
		u.setCpf("14491745");
		u.setLogin("3muito loko");
		u.setNome("Quem5?? Rapa");
		u.setSenha("121245");

		UsuarioDAO UsuarioDao = new UsuarioDAO();
		UsuarioDao.cadastrar(u);
		
		System.out.println("Cadastrado c Sucesso");
	}
}
