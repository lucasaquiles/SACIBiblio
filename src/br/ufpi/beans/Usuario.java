package br.ufpi.beans;

public class Usuario {

	private Long id;
	private String nome;
	private String matricula;
	private String senha;

	public Usuario() {

	}

	public Usuario(Long id, String nome, String matricula, String senha) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
