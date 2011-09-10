package br.ufpi.beans;

import java.io.Serializable;

public class Livro implements Serializable {
	
	private long id;
	private String titulo;
	private String descricao;
	private int quantidade;
	private boolean status;
	private int resourceImage;

	
	
	
	public Livro(int quantidade, String titulo, String descricao) {

		this.titulo = titulo;
		this.descricao = descricao;
		this.quantidade = quantidade;

	}

	
	public long getId(){
		return id;
	}
	
	public boolean getStatus(){
		
		return status;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String toString() {
		return getTitulo();
	}
}
