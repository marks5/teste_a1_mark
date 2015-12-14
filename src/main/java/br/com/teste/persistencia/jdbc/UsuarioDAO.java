package br.com.teste.persistencia.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.teste.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	public void cadastrar(Usuario u) {
		String sql = "INSERT INTO aluno (nome,cpf,login,senha) VALUES (?,?,?,md5(?))";
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
		String sql = "UPDATE ALUNO SET nome=?, cpf=?, login=?, senha=md5(?) where idAluno=?";
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

	public void salvar(Usuario u){
		if(u.getIdAluno() != null && u.getIdAluno()!=0 && u.getSenha()!=""){
			alterar(u);
		}else{
			cadastrar(u);
		}
	}
	
	
	/**
	 * Buscar registro no BD usando o ID do Aluno
	 * @param idAluno E um inteiro que representa o id do aluno
	 * @return Um objeto usuario se encontra um aluno, senão retorna nulo.
	 */
	public Usuario buscarPorId(Integer idAluno){
		String sql = "select * from aluno where idAluno=?"; 
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, idAluno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setIdAluno(rs.getInt("idAluno"));
				u.setCpf(rs.getString("cpf"));
				u.setLogin(rs.getString("login"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				
				return u;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * Realiza a busca de todos os Usuarios do banco de dados
	 * @return Um ArrayList de usuarios.
	 */
	public List<Usuario> buscarTodos(){
		String sql = "select * from aluno"; 
		List<Usuario> lista = new ArrayList<Usuario>();
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setIdAluno(rs.getInt("idAluno"));
				u.setCpf(rs.getString("cpf"));
				u.setLogin(rs.getString("login"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				
				lista.add(u);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}

	
	public Usuario autenticar(Usuario uConsulta){
		String sql = "select * from aluno where login=? and senha=md5(?)";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, uConsulta.getLogin());
			ps.setString(2, uConsulta.getSenha());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Usuario u = new Usuario();
				u.setNome(rs.getString("nome"));
				u.setIdAluno(rs.getInt("idAluno"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setCpf(rs.getString("cpf"));
				return u;
			}
			return null;	 
			}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
