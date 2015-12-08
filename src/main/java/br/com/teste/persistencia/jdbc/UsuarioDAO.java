package br.com.teste.persistencia.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import br.com.teste.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	public void cadastrar(Usuario u) {
		String sql = "INSERT INTO aluno (nome,cpf,login,senha) VALUES (?,?,?,?)";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, u.getNome());
			ps.setString(2, u.getCpf());
			ps.setString(3, u.getLogin());
			ps.setString(4, u.getSenha());
			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	public void alterar(Usuario u) {
		String sql = "UPDATE ALUNO SET nome=?, cpf=?, login=?, senha=? where idAluno=?";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, u.getNome());
			ps.setString(2, u.getCpf());
			ps.setString(3, u.getLogin());
			ps.setString(4, u.getSenha());
			ps.setInt(5, u.getIdAluno());
			ps.execute();
		
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void excluir(Usuario u) {
		String sql = "DELETE from aluno where idAluno=?";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, u.getIdAluno());
			ps.execute();
		
		}catch (SQLException e){
			e.printStackTrace();
		}
	}	


}
