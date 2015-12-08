package br.com.teste;

import br.com.teste.entidade.Usuario;
import br.com.teste.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//Alterar();
		//Excluir();
		Salvar();
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
