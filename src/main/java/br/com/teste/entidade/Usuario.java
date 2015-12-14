package br.com.teste.entidade;

public class Usuario {

	private Integer idAluno;
	private String nome, cpf, login, senha;
	
	public Integer getIdAluno() {
		return idAluno;
	}
	@Override
	public String toString() {
		return "Usuario [idAluno=" + idAluno + ", nome=" + nome + ", cpf=" + cpf + ", login=" + login + ", senha="
				+ senha + "]";
	}
	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
